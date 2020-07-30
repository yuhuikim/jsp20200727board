package article.service;

import article.model.Article;
import article.model.ArticleContent;

public class ArticleData {
	private Article article;
	private ArticleContent content;

	public ArticleData(Article article, ArticleContent content) {
		this.content = content;
		this.article = article;
	}

	public Article getArticle() {
		return article;
	}

	public String getContent() {
		return content.getContent();
	}
}
