package domain;
//用于封装用户的查询结果

import java.util.List;

public class QueryResult {
	private List list ; //记住用户看得页面的数据
	private int totalrecord; // 总记录数
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	
}
