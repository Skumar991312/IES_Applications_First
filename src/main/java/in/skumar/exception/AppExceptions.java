package in.skumar.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppExceptions {

	private String exCode;

	private String exDesc;

	private LocalDateTime exDate;

}
