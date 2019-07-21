package com.dotsub.dto;

import com.dotsub.utility.OutputResponse;
import com.dotsub.utility.Pagination;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Snailin Inoa
 */
@JsonInclude(Include.NON_NULL)
public class GenericModelDTO<T> extends OutputResponse {

    private List<T> list = null;
    private T singleObject = null;
    private Pagination pagination;
    private Map extraInfo;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getSingleObject() {
        return singleObject;
    }

    public void setSingleObject(T singleObject) {
        this.singleObject = singleObject;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Map getExtraInfo() {

        return extraInfo;
    }

    public void setExtraInfo(Map extraInfo) {
        this.extraInfo = extraInfo;
    }

}
