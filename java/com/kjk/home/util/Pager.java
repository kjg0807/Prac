package com.kjk.home.util;

public class Pager
{
	private Long page;
	private Long perPage = 10L;
	private Long startRow;

	public void makeRow()
	{
		this.startRow = (this.getPage() - 1) * perPage;
	}

	public void setPage(Long page)
	{
		this.page = page;
	}

	public Long getPage()
	{
		if (this.page == null || this.page < 1)
		{
			this.page = 1L;
		}
		return this.page;
	}

	public Long getPerPage()
	{
		return perPage;
	}

	public void setPerPage(Long perPage)
	{
		this.perPage = perPage;
	}

	public Long getStartRow()
	{
		return startRow;
	}


}
