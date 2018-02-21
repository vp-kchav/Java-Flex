package com.vecteurplus.inventory.manager {
	
	import com.vecteurplus.inventory.model.Product;
	
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.collections.ArrayList;
	
	public class ProductManager extends EventDispatcher {
		
		private var _currentProducts:ArrayCollection;
		private var _updatedProduct:Product;
		private var _deletedProduct:Product;
		private var _categoryList:ArrayCollection;
		private var _currentCategories:ArrayCollection;
		
		public function set categoryList(categories:ArrayCollection):void {
			_categoryList = categories;
		}
		
		[Bindable]
		public function get categoryList():ArrayCollection {
			return _categoryList;
		}
		
		public function storeCategories(categories:ArrayCollection):void {
			categoryList = categories;
		}
		
		public function set currentProducts(products:ArrayCollection):void {
			_currentProducts = products;
		}
		
		[Bindable]
		public function get currentProducts():ArrayCollection {
			return _currentProducts;
		}
		
		public function storeProducts(products:ArrayCollection):void {
			currentProducts = products;
		}
		
		public function set updatedProduct(product:Product):void {
			_updatedProduct = product;
		}
		
		[Bindable]
		public function get updatedProduct():Product {
			return _updatedProduct;
		}
		
		public function storeUpdatedProduct(product:Product):void {
			updatedProduct = product;
		}
		
		public function set deletedProduct(product:Product):void {
			_deletedProduct = product;
		}
		
		[Bindable]
		public function get deletedProduct():Product {
			return _deletedProduct;
		}
		
		public function storeDeletedProduct(product:Product):void {
			deletedProduct = product;
		}

		[Bindable]
		public function get currentCategories():ArrayCollection {
			return _currentCategories;
		}

		public function set currentCategories(value:ArrayCollection):void {
			_currentCategories = value;
		}

	}
}