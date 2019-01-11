package ca.bcit.com4613.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.model.DataModel;

import ca.bcit.com4613.entity.Employee;

public class SortFilter<E> extends DataModel<E> {
	private DataModel<E> model;
	private List<Integer> rows;
	
	public SortFilter() { // mandated by JSF spec
		setWrappedData(null);
	}

	public SortFilter(List<Employee> names) { // recommended by JSF spec
		setWrappedData(names);
	}

	public SortFilter(DataModel<E> model) {
		this.model = model;
		initializeRows();
	}
	
	public DataModel<E> getEmployees() {
		return model;
	}
	
	@Override
	public boolean isRowAvailable() {
		return model.isRowAvailable();
	}
	@Override
	public int getRowCount() {
		return model.getRowCount();
	}
	@Override
	public E getRowData() {
		return model.getRowData();
	}
	@Override
	public int getRowIndex() {
		return model.getRowIndex();
	}
	@Override
	public void setRowIndex(int rowIndex) {
		if (0 <= rowIndex && rowIndex < rows.size())
			model.setRowIndex(rows.get(rowIndex));
		else
			model.setRowIndex(rowIndex);		
	}
	@Override
	public Object getWrappedData() {
		return model.getWrappedData();
	}
	@Override
	public void setWrappedData(Object data) {
		model.setWrappedData(data);
		initializeRows();
	}
	
	private void initializeRows() {
		int rowCnt = model.getRowCount();
		if (rowCnt != -1) {
			rows = new ArrayList<>(rowCnt);
			for (int i = 0; i < rowCnt; ++i)
				rows.add(i);
		}
	}	

}
