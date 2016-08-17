package com.mukeshteckwani.models;

import java.io.Serializable;

/**
 * Created by mukeshteckwani on 14/08/16.
 */


public class MedicineName implements Serializable {
    private String message;

    private boolean hasMore;

    private String totalRecordCount;

    private Result[] result;

    private String errors;

    private String op;

    private String status;

    private String searchTerm;

    private Context context;

    private String[] suggestions;

    private String TEMP_USER_ID;

//    private String header;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(String totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public Result[] getResult() {
        return result;
    }

    public void setResult(Result[] result) {
        this.result = result;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String[] getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String[] suggestions) {
        this.suggestions = suggestions;
    }

    public String getTEMP_USER_ID() {
        return TEMP_USER_ID;
    }

    public void setTEMP_USER_ID(String TEMP_USER_ID) {
        this.TEMP_USER_ID = TEMP_USER_ID;
    }

}