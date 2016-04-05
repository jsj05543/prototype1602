class MyD3
	size:{width:500,height:400}
	lots:10
	getGraphWidth:->
		console.log @size.width/@lots
		return @size.width/@lots
	
	getRandomColor:->
		r = Math.round (Math.random()*255)+1
		g = Math.round (Math.random()*255)+1
		b = Math.round (Math.random()*255)+1
		return "rgb("+r+","+g+","+b+")"
	
	generateData:->
		maxValue = @size.height
		list = []
		for i in [1...@lots]
			list.push Math.round(Math.random() * maxValue)
		return list

	bowGraph:->
		data = @generateData()
		svg = d3.select("#bowGraph").append("svg")
		svg.attr({
			width:@size.width,
			height:@size.height
			});
		svg.selectAll("rect")
			.data(data)
			.enter()
			.append('rect')
			.attr({
				x:(d,i)=>
					return i * @getGraphWidth()
				,
				y:(d)=>
					return @size.height-d
				,
				width:(d)=>
					return @getGraphWidth()
				,
				height:(d)->
					return d
				,
				fill:=>
					return @getRandomColor()
				stroke:"rgb(0,0,0)"
					
				});
		svg.selectAll("text")
			.data(data)
			.enter()
			.append("text")
			.attr({
				x:(d,i)=>
					return (i*@getGraphWidth())+(@getGraphWidth()/2)
				,
				y:(d,i)=>
					return @size.height-d+20
				})
			.text((d)->
			      	return d
			      );
		return
		
		
	circleGraph:(data)->
		svg = d3.select("#circleGraph").append("svg")
		svg.attr({
			width:@size.width,
			height:@size.height
			});
		
	test:->
		console.log @generateData()
obj = new MyD3()
obj.bowGraph()
obj.circleGraph()