package com.vecteurplus.inventory.manager {
	
	import com.vecteurplus.inventory.model.Stock;
	
	import flash.events.EventDispatcher;
	
	import mx.collections.ArrayCollection;

	public class StockManager extends EventDispatcher {
		
		private var _currentStocks:ArrayCollection;
		private var _updatedStock:Stock
		private var _deletedStock:Stock;
		private var _productList:ArrayCollection;
		
		public function set productList(products:ArrayCollection):void {
			_productList = products;
		}
		
		[Bindable]
		public function get productList():ArrayCollection {
			return _productList;
		}
		
		public function storeProducts(products:ArrayCollection):void {
			productList = products;
		}
		
		public function set currentStocks(stocks:ArrayCollection):void {
			_currentStocks = stocks;
		}
		
		[Bindable]
		public function get currentStocks():ArrayCollection {
			return _currentStocks;
		}
		
		public function storeStocks(stocks:ArrayCollection):void {
			currentStocks = stocks;
		}
		
		public function set updatedStock(stock:Stock):void {
			_updatedStock = stock;
		}
		
		[Bindable]
		public function get updatedStock():Stock {
			return _updatedStock;
		}
		
		public function storeUpdatedStock(stock:Stock):void {
			updatedStock = stock;
		}
		
		public function set deletedStock(stock:Stock):void {
			_deletedStock = stock;
		}
		
		[Bindable]
		public function get deletedStock():Stock {
			return _deletedStock;
		}
		
		public function storeDeletedStock(stock:Stock):void {
			deletedStock = stock;
		}
	}
}