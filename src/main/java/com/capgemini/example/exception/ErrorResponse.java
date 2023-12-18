package com.capgemini.example.exception;

import java.time.LocalDateTime;



public class ErrorResponse {

		private String errormessage;
		private String status;
		private LocalDateTime localDateTime;
		public String getErrormessage() {
			return errormessage;
		}
		public void setErrormessage(String errormessage) {
			this.errormessage = errormessage;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public LocalDateTime getLocalDateTime() {
			return localDateTime;
		}
		public void setLocalDateTime(LocalDateTime localDateTime) {
			this.localDateTime = localDateTime;
		}
	}


