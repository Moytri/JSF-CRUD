package ca.bcit.com4613.bean;

import java.io.Serializable;
import java.util.List;

public class PaginationHelper<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	private int totalRows;
	private int firstRow;
	private int rowsPerPage = 5;
	private int totalPages;
	private int pageRange = 5;
	private Integer[] pages;
	private int currentPage;
	
	private List<E> employees;
	private List<E> emps;

	
	public PaginationHelper() {
		
	}
	
	public PaginationHelper(List<E> emps) {
		this.emps = emps;
	}
	
	public PaginationHelper(List<E> emps, int totalRows, int firstRow, int rowsPerPage, int totalPages,
			int pageRange, Integer[] pages, int currentPage) {
		this.emps = emps;
		this.totalRows = totalRows;
		this.firstRow = firstRow;
		this.rowsPerPage = 5;
		this.totalPages = totalPages;
		this.pageRange = 5;
		this.pages = pages;
		this.currentPage = currentPage;
	}


	public List<E> getOriginalList() {
		return emps;
	}
		
	public void setEmps(List<E> emps) {
		this.emps = emps;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getPageRange() {
		return pageRange;
	}

	public Integer[] getPages() {
		return pages;
	}

	public int getCurrentPage() {
		return currentPage;
	}


	private void loadEmployees() {
		employees = emps;
		totalRows = emps.size();

		// last page
		if (firstRow + rowsPerPage > totalRows) {
			employees = employees.subList(firstRow, totalRows);
		} 
		// if you click on next button and you're not on the last page
		else if (firstRow != 0 && rowsPerPage < totalRows) {
			employees = employees.subList(firstRow, firstRow + rowsPerPage);
		} 
		
		else { // first page
			employees = employees.subList(firstRow, rowsPerPage);
		}

		// Set currentPage, totalPages and pages.
		currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow) / rowsPerPage) + 1;
		totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int pagesLength = Math.min(pageRange, totalPages);
		pages = new Integer[pagesLength];

		// firstPage must be greater than 0 and lesser than
		// totalPages-pageLength.
		int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);

		// Create pages (page numbers for page links).
		for (int i = 0; i < pagesLength; i++) {
			pages[i] = ++firstPage;
		}
	}
	
	public List<E> getEmployees() {
		if (employees == null) {
			loadEmployees();
		}
		return employees;
	}

	// Paging actions
	// -----------------------------------------------------------------------------
	public void pageFirst() {
		page(0);
	}

	public void pageNext() {
		page(firstRow + rowsPerPage);
	}

	public void pagePrevious() {
		page(firstRow - rowsPerPage);
	}

	public void pageLast() {
		page(totalRows - ((totalRows % rowsPerPage != 0) ? totalRows % rowsPerPage : rowsPerPage));
	}

	public void page(int firstRow) {
		this.firstRow = firstRow;
		loadEmployees();
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}

	public void setPages(Integer[] pages) {
		this.pages = pages;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setEmployees(List<E> employees) {
		this.employees = employees;
	}
	
	
}
