Ext.onReady(function() {
	Ext.get('myButton').on('click', function() {
		Ext.select('p').highlight();
	});
	Ext.select('p').on('click', function() { 
		alert('You clicked a paragraph!'); 
	}); 

});
