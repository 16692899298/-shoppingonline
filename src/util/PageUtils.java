package util;

import java.util.List;

public class PageUtils<E> {
	private List<E> list;  
    private int pageNo;  //当前页号
    private int pageSize;   //每页显示的条数 
    private int totalNum;   //总共的条数  
    private int totalPage;  //页数总数
  
    public List<E> getList() {  
        return list;  
    }  
  
    public void setList(List<E> list) {  
        this.list = list;  
    }  
  
    public int getPageNo() {  
        return pageNo;  
    }  
  
    public void setPageNo(int pageNo) {  
        this.pageNo = pageNo;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public int getTotalNum() {  
        return totalNum;  
    }  
  
    public void setTotalNum(int totalNum) {  
        this.totalNum = totalNum;  
        setTotalPage((getTotalNum() % pageSize) == 0 ? (getTotalNum() / pageSize)  
                : (getTotalNum() / pageSize + 1));  
    }  
  
    public int getTotalPage() {  
        return totalPage;  
    }  
  
    public void setTotalPage(int totalPage) {  
        this.totalPage = totalPage;  
    }  
	
	
	
	
	
}
