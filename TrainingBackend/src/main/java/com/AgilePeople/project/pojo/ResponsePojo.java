package com.AgilePeople.project.pojo;

public class ResponsePojo {
    private Boolean isError;
    private Boolean isSuccess;
    private String successMsg;
    private String errorMessage;
    private Object data;

    public ResponsePojo() {
    }

    public ResponsePojo(Boolean isError, Boolean isSuccess, String successMsg, String errorMessage, Object data) {
        this.isError = isError;
        this.isSuccess = isSuccess;
        this.successMsg = successMsg;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public void setError(Boolean error) {
        isError = error;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = successMsg;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getError() {
        return isError;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public String getSuccessMsg() {
        return successMsg;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Object getData() {
        return data;
    }
}
