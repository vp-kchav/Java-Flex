package com.vecteurplus.inventory.event {
	
	import com.vecteurplus.inventory.model.Stock;
	
	import flash.events.Event;
	
	public class StockEvent extends Event {
		
		public static const SAVE_STOCK:String = "saveStock";
		public static const UPDATE_STOCK:String = "updateStock";
		public static const DELETE_STOCK:String = "deleteStock";
		public static const SEARCH_STOCK:String = "searchStock";
		public static const GET_SELECTED_STOCK:String = "getSelectedStock";
		public static const DISPLAY_SELECTED_STOCK:String = "displaySelectedStock";
		public static const GET_ALL_STOCKS:String = "getAllStocks";
		
		private var _stock:Stock;
		private var _stockId:int;
		
		public function StockEvent(type:String, bubbles:Boolean = true, cancelable:Boolean = false) {
			super(type, bubbles, cancelable);
		} 
		
		public function set stockId(id:int):void {
			_stockId = id;
		}
		
		public function get stockName():int {
			return _stockId;
		}
		
		public function set stock(st:Stock):void {
			_stock = st;
		}
		
		public function get stock():Stock {
			return _stock;
		}
	}
}