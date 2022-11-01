package com.kjk.home.util;

import lombok.Data;

@Data
public class Pager
{
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	// privous block exist true, not exist false
	private boolean pre;
	// next block exist true, not exist false
	private boolean next;

	private String title;
	private String contents;
	private String writer;

	// private Long offset;

	public String getContents()
	{
		return contents;
	}

	public void setContents(String contents)
	{
		this.contents = contents;
	}

	public String getWriter()
	{
		return writer;
	}

	public void setWriter(String writer)
	{
		this.writer = writer;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	// 검색 컬럼의 종류
	private String kind;
	// 검색어
	private String search;

	public String getKind()
	{
		return kind;
	}

	public void setKind(String kind)
	{
		this.kind = kind;
	}

	public String getSearch()
	{
		if (this.search == null)
		{
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search)
	{
		this.search = search;
	}

	public boolean isPre()
	{
		return pre;
	}

	public void setPre(boolean pre)
	{
		this.pre = pre;
	}

	public boolean isNext()
	{
		return next;
	}

	public void setNext(boolean next)
	{
		this.next = next;
	}

	public Pager()
	{
		this.perPage = 10L;
		this.perBlock = 5L;
		// this.offset = this.perPage + 16;
	}

	// 1. mapper에서 사용할 값 계산
	public void getRowNum() throws Exception
	{
		this.startRow = (this.getPage() - 1) * this.getPerPage();
		this.lastRow = this.getPerPage() * this.getPage();
	}

	// 2. jsp에서 사용할 값 계산
	public void getNum(Long totalCount) throws Exception
	{
		// 2. totalCount로 totalPage 구하기
		Long totalPage = totalCount / this.getPerPage();
		if (totalCount % this.getPerPage() != 0)
		{
			totalPage++;
		}
		// 2-1. totalPage보다 page가 더 클 경우
		// System.out.println("TotalPage: " + totalPage);
		// System.out.println("getPage: " + this.getPage());
		if (totalPage < this.getPage())
		{
			this.setPage(totalPage);
		}

		// 3. totalPage로 totalBlock 구하기
		Long totalBlock = totalPage / this.getPerBlock();
		if (totalPage % this.getPerBlock() != 0)
		{
			totalBlock++;
		}
		// 4. page로 curBlock 찾기
		Long curBlock = this.getPage() / this.getPerBlock();
		if (this.getPage() % this.getPerBlock() != 0)
		{
			curBlock++;
		}
		// 5. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock - 1) * this.getPerBlock() + 1;
		this.lastNum = curBlock * this.getPerBlock();

		// 6. cutBlock이 마지막block(totalBlock과 같을 때)
		if (curBlock == totalBlock)
		{
			this.lastNum = totalPage;
		}
		// 7. 이전, 다음 블럭의 유무
		if (curBlock > 1) // 현재 블럭이 1보다 클때
		// 현재 블럭이 2보다 작을때 이전 버튼이 없어짐
		{
			pre = true;
		}
		if (curBlock < totalBlock) // 현재 블럭이 전체 블럭보다 작을 때
		// 현재 블럭이 전체 블럭과 같거나 클때 다음 버튼이 없어짐
		{
			next = true;
		}
	}

	public Long getPerPage()
	{
		if (this.perPage == null)
		{
			this.perPage = 10L;
		}

		return perPage;
	}

	public void setPerPage(Long perPage)
	{
		this.perPage = perPage;
	}

	public Long getPerBlock()
	{
		return perBlock;
	}

	public void setPerBlock(Long perBlock)
	{
		this.perBlock = perBlock;
	}

	public Long getPage() // page number control < 0
	{
		if (this.page == null || this.page < 1)
		{
			this.page = 1L;
		}

		return page;
	}

	public void setPage(Long page)
	{
		this.page = page;
	}

	public Long getStartNum()
	{
		return startNum;
	}

	public void setStartNum(Long startNum)
	{
		this.startNum = startNum;
	}

	public Long getLastNum()
	{
		return lastNum;
	}

	public void setLastNum(Long lastNum)
	{
		this.lastNum = lastNum;
	}

	public Long getStartRow()
	{
		return startRow;
	}

	public void setStartRow(Long startRow)
	{
		this.startRow = startRow;
	}

	public Long getLastRow()
	{
		return lastRow;
	}

	public void setLastRow(Long lastRow)
	{
		this.lastRow = lastRow;
	}

	// public void makeRow()
	// {
	// this.startRow = (this.getPage() - 1) * perPage;
	// }

	// private Long page;
	// private Long perPage = 10L;
	// private Long startRow;
	//
	//
	// public void setPage(Long page)
	// {
	// this.page = page;
	// }
	//
	// public Long getPage()
	// {
	// if (this.page == null || this.page < 1)
	// {
	// this.page = 1L;
	// }
	// return this.page;
	// }
	//
	// public Long getPerPage()
	// {
	// return perPage;
	// }
	//
	// public void setPerPage(Long perPage)
	// {
	// this.perPage = perPage;
	// }
	//
	// public Long getStartRow()
	// {
	// return startRow;
	// }

}
