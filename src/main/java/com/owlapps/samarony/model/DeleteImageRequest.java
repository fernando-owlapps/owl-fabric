package com.owlapps.samarony.model;

public class DeleteImageRequest {
	
	private Long productId;
	private Long indexImage;
	
	
	public DeleteImageRequest() {
	}

	public DeleteImageRequest(Long productId, Long indexImage) {
		super();
		this.productId = productId;
		this.indexImage = indexImage;
	}

	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getIndexImage() {
		return indexImage;
	}
	public void setIndexImage(Long indexImage) {
		this.indexImage = indexImage;
	}

	@Override
	public String toString() {
		return "DeleteImageRequest [productId=" + productId + ", indexImage=" + indexImage + "]";
	}
	
}
