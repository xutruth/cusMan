package domain;

import java.util.List;

//QueryResult中对象中封装的查询结果，生成显示分页数据的PageBean对象
public class PageBean {
	private List list;
	private int totalrecord;
	private int pagesize;
	private int totalpage;
	private int currentpage;
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
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		if(this.totalrecord%this.pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize + 1;
		}
		return totalpage;
	}
	/*public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}*/
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if(this.currentpage-1<1){
			this.previouspage =1;
		}else{
			this.previouspage = this.currentpage - 1;
		}
		return previouspage;
	}
	/*public void setPreviouspage(int previouspage) {
		this.previouspage = previouspage;
	}*/
	public int getNextpage() {
		 if (this.currentpage + 1 >= this.totalpage) {
	            this.nextpage = this.totalpage;
	        } else {
	            this.nextpage = this.currentpage + 1;
	        }
		return nextpage;
	}
	/*public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}*/
	public int[] getPagebar() {
		int[] pagebar = null;
        int startpage; // 起始页码
        int endpage; // 结束页码

        if (this.totalpage <= 10) {
            pagebar = new int[this.totalpage];
            startpage = 1;
            endpage = this.totalpage;
        } else {
            //                              currentpage
            // 11       12       13      14      15      16      17      18      19      20
            // 19       20       21      22      23      24      25      26      27      28
            pagebar = new int[10];
            startpage = this.currentpage - 4;
            endpage = this.currentpage + 5;

            // 总页数=30，假设看的是第3页，则startpage=-1
            // 总页数=30，假设看的是第29页，则endpage=34
            if (startpage < 1) {
                startpage = 1;
                endpage = 10;
            }

            if (endpage > this.totalpage) {
                endpage = this.totalpage;
                startpage = this.totalpage - 9;
            }
            
        }
        int index = 0;
        for (int i = startpage; i <= endpage; i++) {
            pagebar[index++] = i;
        }
        this.pagebar = pagebar;
        return this.pagebar;
	}
	/*public void setPagebar(int[] pagebar) {
		this.pagebar = pagebar;
	}*/
	private int previouspage;
	private int nextpage;
	private int [] pagebar;
}
