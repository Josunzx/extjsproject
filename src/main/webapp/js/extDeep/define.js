Ext.define('My.sample.Person', {
	name : 'Unknown',
	constructor : function(name,name2) {
		if (name) {
			this.name = name;
		}
		if(name2){
			this.name2 = name2;
		}
		return this;
	},
	eat : function(foodType) {
		alert(this.name + " and " + this.name2 + " are eating: " + foodType);
		return this;
	} });
//var aaron = new My.sample.Person('Tom', 'Jerry');
var aaron = Ext.create('My.sample.Person', 'Aaron', 'Athon');
aaron.eat("Salad");
