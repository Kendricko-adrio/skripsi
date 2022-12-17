package com.skripsi.userskripsi.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {
  @JsonProperty("status")
  private Integer status;

  @JsonProperty("message")
  private String message;

  @JsonProperty("data")
  private T data;

  public String toString() {
    return "Response(status=" + this.getStatus() + ", message=" + this.getMessage() + ", data="
        + this.getData() + ")";
  }

  public static <T> ResponseBuilder<T> builder() {
    return new ResponseBuilder<>();
  }

  public Integer getStatus() {
    return this.status;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  @JsonProperty("status")
  public void setStatus(Integer status) {
    this.status = status;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  @JsonProperty("data")
  public void setData(T data) {
    this.data = data;
  }

  public Response(final Integer status, final String message, final T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public Response() {
  }

  public static class ResponseBuilder<T> {
    private Integer status;
    private String message;
    private T data;

    ResponseBuilder() {
    }

    @JsonProperty("status")
    public ResponseBuilder<T> status(final Integer status) {
      this.status = status;
      return this;
    }

    @JsonProperty("message")
    public ResponseBuilder<T> message(final String message) {
      this.message = message;
      return this;
    }

    @JsonProperty("data")
    public ResponseBuilder<T> data(final T data) {
      this.data = data;
      return this;
    }

    public Response<T> build() {
      return new Response<T>(this.status, this.message, this.data);
    }

    public String toString() {
      return "Response.ResponseBuilder(status=" + this.status + ", message=" + this.message
          + ", data=" + this.data + ")";
    }

  }
}
