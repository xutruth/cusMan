package domain;
//QueryInfo类，用于封装用户的请求参数
public class QueryInfo {
	private int currentpage = 1; //当前页
	private int pagesize =  5 ; //记录用户想看到的页面大小
	private int startindex; //记住用户看的页的数据在数据库表中的起始位置
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartindex() {
		return startindex;
	}
	public void setStartindex(int startindex) {
		this.startindex = (this.currentpage-1)*pagesize;
	}
	
}
