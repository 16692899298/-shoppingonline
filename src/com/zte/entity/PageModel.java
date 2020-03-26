package com.zte.entity;

import java.util.ArrayList;
import java.util.List;

public class PageModel<E> {
	private List<Product> list;  
    private int pageNo;//当前页
    private int pageSize;  //每页显示的条数12 
    private int totalNum; //总共的条数  63
    private int totalPage;  //页数总数6
    private List<Integer> pageList;//页号数组
    private String source;//用于判读执行的标记属性 0表示所有产品  1表示大类产品 2表示小类产品 3表示模糊查询
    private int hpcId;//保存类id的属性
    private int currentPage;//保存当前页号
    private String qname;//保存搜索商品名
/* 
    select * from
(select a.*,rownum rn from
(select * from  hwua_product) a
)
where rn between 1 and 12*/


  //无参构造方法
    public PageModel() {
		
	}
    
    
    
    
    
	public PageModel(List<Product> list, int pageNo, int pageSize, int totalNum,String source,int hpcId,int currentPage) {
		this.list = list;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.source=source;
		this.hpcId=hpcId;
		this.currentPage=currentPage;
		
		setTotalPage((getTotalNum() % pageSize) == 0 ? (getTotalNum() / pageSize)  
                : (getTotalNum() / pageSize + 1)); 
		
		int total = getTotalPage();
		
		List<Integer> pl = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			pl.add(i+1);
		}
		setPageList(pl);
	}

	
	
	public PageModel(List<Product> list, int pageNo, int pageSize, int totalNum,String source,String qname,int currentPage) {
		this.list = list;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.source=source;
		this.qname=qname;
		this.currentPage=currentPage;
		setTotalPage((getTotalNum() % pageSize) == 0 ? (getTotalNum() / pageSize)  
                : (getTotalNum() / pageSize + 1)); 
		
		int total = getTotalPage();
		List<Integer> pl = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			pl.add(i+1);
		}
		setPageList(pl);
	}
	
	
	
	

	public String getQname() {
		return qname;
	}





	public void setQname(String qname) {
		this.qname = qname;
	}





	public int getCurrentPage() {
		return currentPage;
	}





	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}





	public int getHpcId() {
		return hpcId;
	}





	public void setHpcId(int hpcId) {
		this.hpcId = hpcId;
	}





	public String getSource() {
			return source;
		}





	public void setSource(String source) {
			this.source = source;
		}

	public List<Integer> getPageList() {
		return pageList;
	}


	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}





	public List<Product> getList() {  
        return list;  
    }  
  
    public void setList(List<Product> list) {  
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
        
    }  
  
    public int getTotalPage() {  
        return totalPage;  
    }  
  
    public void setTotalPage(int totalPage) {  
        this.totalPage = totalPage;  
    }  
  
    // 获取第一页  
    public int getFirstPage() {  
        return 1;  
    }  
  
 // 获取最后页  
    public int getLastPage() {  
        return totalPage;  
    }  
  
 // 获取前页    
    public int getPrePage() {  
        if (pageNo > 1)  
            return pageNo - 1;  
        return 1;  
    }  
  
 // 获取后页  
    public int getBackPage() {  
        if (pageNo < totalPage)  
            return pageNo + 1;  
        return totalPage;  
    }  
  
    // 判断'首页'及‘前页’是否可用  
    public String isPreable() {  
        if (pageNo == 1)  
            return "disabled";  
        return "";  
    }  
  
    // 判断'尾页'及‘下页’是否可用 
    public String isBackable() {  
        if (pageNo == totalPage)  
            return "disabled";  
        return "";  
    }





	@Override
	public String toString() {
		return "PageModel [list=" + list + ", pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalNum=" + totalNum
				+ ", totalPage=" + totalPage + ", pageList=" + pageList + ", source=" + source + ", hpcId=" + hpcId
				+ ", currentPage=" + currentPage + ", qname=" + qname + "]";
	}


	
    
    
    
    
}
