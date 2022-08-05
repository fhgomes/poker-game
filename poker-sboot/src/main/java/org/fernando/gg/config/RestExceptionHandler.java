package org.fernando.gg.config;

import static java.lang.String.format;
import static org.fernando.gg.core.constants.ErrorConstants.ERR_CODE_INTERNAL_UNKNOWN;
import static org.fernando.gg.core.constants.ErrorConstants.ERR_LOG_PREFIX;

import java.util.List;

import org.fernando.gg.core.constants.ErrorConstants;
import org.fernando.gg.core.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler({ AccessDeniedException.class })
	@ResponseBody
	public ResponseEntity<List<ErrorDTO>> exceptionHandler(AccessDeniedException e) {
		if (log.isErrorEnabled()) {
			log.error(format("%s Permission exception: { %s }", ERR_LOG_PREFIX, e.getMessage()));
		}

		return ResponseEntity
			.status(HttpStatus.FORBIDDEN)
			.body(List.of(new ErrorDTO(ErrorConstants.ERR_CODE_ACCESS_DENIED, e.getMessage())));
	}

    @ExceptionHandler({ HttpStatusCodeException.class })
    @ResponseBody
    public ResponseEntity<List<ErrorDTO>> exceptionHandler(HttpStatusCodeException e) {
		log.error(format("%s Print error: { %s }", ERR_LOG_PREFIX, e.getMessage()), e);
        return ResponseEntity
                .status(e.getStatusCode())
                .body(List.of(new ErrorDTO(Long.valueOf(e.getStatusCode().value()), e.getMessage())));
    }

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseEntity<List<ErrorDTO>> exceptionHandler(Exception e) {
		log.error(" ===  Unknown error handler === ");
		log.error(format("%s Unknown error: { %s }", ERR_LOG_PREFIX, e.getMessage()), e);
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(List.of(new ErrorDTO(ERR_CODE_INTERNAL_UNKNOWN, e.getMessage())));
	}


}
