package com.skripsi.graphqlserver.model.request;

public class Request {
  private String query;
  private String operationName;
  private Object variables;

  public String getQuery() {
    return this.query;
  }

  public String getOperationName() {
    return this.operationName;
  }

  public Object getVariables() {
    return this.variables;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public void setVariables(Object variables) {
    this.variables = variables;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof Request)) return false;
    final Request other = (Request) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$query = this.getQuery();
    final Object other$query = other.getQuery();
    if (this$query == null ? other$query != null : !this$query.equals(other$query)) return false;
    final Object this$operationName = this.getOperationName();
    final Object other$operationName = other.getOperationName();
    if (this$operationName == null ? other$operationName != null : !this$operationName.equals(other$operationName))
      return false;
    final Object this$variables = this.getVariables();
    final Object other$variables = other.getVariables();
    if (this$variables == null ? other$variables != null : !this$variables.equals(other$variables))
      return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Request;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $query = this.getQuery();
    result = result * PRIME + ($query == null ? 43 : $query.hashCode());
    final Object $operationName = this.getOperationName();
    result = result * PRIME + ($operationName == null ? 43 : $operationName.hashCode());
    final Object $variables = this.getVariables();
    result = result * PRIME + ($variables == null ? 43 : $variables.hashCode());
    return result;
  }

  public String toString() {
    return "Request(query=" + this.getQuery() + ", operationName=" + this.getOperationName()
        + ", variables="
        + this.getVariables() + ")";
  }
}
