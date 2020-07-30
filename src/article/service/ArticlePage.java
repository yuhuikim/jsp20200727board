package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage {
	//인스턴스 필드
	private int total;
	private int currentPage;
	private List<Article> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public ArticlePage(int total, int currentPage, int size, List<Article> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		//필드를 초기화하기 위한 계산 과정
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			//나누어 떨어지지 않으면 페이지를 1개 추가한다.
			if (total % size > 0) {
				totalPages++;
			}
			
			startPage = (currentPage-1) / 5 * 5 + 1;
			
			endPage = startPage + 4;
			endPage = Math.min(endPage, totalPages);
			
			
		}
	}
	
	public int getTotal() {
		return total;
	}
	
	public boolean hasNoArticles() {
		return total == 0;
	}
	
	public boolean hasArticles() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public List<Article> getContent() { //내용 받아온다.
		return content;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
}
