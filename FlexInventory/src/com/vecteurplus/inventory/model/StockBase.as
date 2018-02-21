package com.vecteurplus.inventory.model {
	
	
	import flash.utils.IDataInput;
	import flash.utils.IDataOutput;
	import flash.utils.IExternalizable;
	
	import org.granite.collections.IPersistentCollection;
	import org.granite.meta;
	
	use namespace meta;
	
	[Bindable]
	public class StockBase implements IExternalizable {
		
		private var _initialized:Boolean = true;
		private var _detachedState:String = null;
		
		private var _code:String;
		private var _id:int;
		private var _product:Product;
		private var _quantity:int;
		
		meta function isInitialized(name:String = null):Boolean {
			if(!name)
				return _initialized;
			var property:* = this[name];
			return (
				(!(property is Stock) || (property as Stock).meta::isInitialized()) &&
				(!(property is IPersistentCollection) || (property as IPersistentCollection).isInitialized())
			);
		}
		
		public function set code(c:String):void {
			_code = c;
		}
		
		public function get code():String {
			return _code;
		}
		
		public function set id(i:int):void {
			_id = i;
		}
		
		public function get id():int {
			return _id;
		}
		
		public function set product(pro:Product):void {
			_product = pro;
		}
		
		public function get product():Product {
			return _product;
		}
		
		public function set quantity(qty:int):void {
			_quantity = qty;
		}
		
		public function get quantity():int {
			return _quantity;
		}

		public function readExternal(input:IDataInput):void {
			_initialized = input.readObject() as Boolean;
			_detachedState = input.readObject() as String;
			if(meta::isInitialized()) {
				_code = input.readObject() as String;				
				_id = input.readObject() as int;
				_product = input.readObject() as Product;
				_quantity = input.readObject() as int;
			}
			else {
				_id = input.readObject() as int;
			}
		}
		
		public function writeExternal(output:IDataOutput):void {
			output.writeObject(_initialized);
			output.writeObject(_detachedState);
			if(meta::isInitialized()) {
				output.writeObject(_code);
				output.writeObject(_id);
				output.writeObject(_product);
				output.writeObject(_quantity);
			}
			else {
				output.writeObject(_id);
			}
		}
	}
}