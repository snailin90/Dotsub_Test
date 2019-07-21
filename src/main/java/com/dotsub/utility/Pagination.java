package com.dotsub.utility;

import org.springframework.data.domain.Sort;

/**
 *
 * @author Snailin Inoa
 */
public class Pagination {

    private int totalPages;
    private long totalElements;
    private int actualSize;
    private int actualPageNumber;
    private boolean first;
    private boolean last;
    private int numberOfElements;
    private Sort sort;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }

    public int getActualPageNumber() {
        return actualPageNumber;
    }

    public void setActualPageNumber(int actualPageNumber) {
        this.actualPageNumber = actualPageNumber;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Pagination{"
                + "totalPages=" + totalPages
                + ", totalElements=" + totalElements
                + ", actualSize=" + actualSize
                + ", actualPageNumber=" + actualPageNumber
                + ", first=" + first
                + ", last=" + last
                + ", numberOfElements=" + numberOfElements
                + ", sort=" + sort
                + '}';
    }
}
