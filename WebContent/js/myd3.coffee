class MyD3
	size:{width:500,height:400}
	lots:10
	radius:180
	innerRadius:50
	getGraphWidth:->
		return @size.width/@lots
	
	getRandomColor:(value)->
		# ¸îºÏ¤ò³ö¤·¡¢255¤ò’ì¤±¤ë
		temp = Math.round (value/@size.height)*255
		r = (temp-255)*-1
		g = temp
		b = 50
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
				fill:(d)=>
					return @getRandomColor(d)
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
		
		
	circleGraph:()->
		data = @generateData()
		svg = d3.select("#circleGraph").append("svg")
			.attr({
			width:@size.width,
			height:@size.height
			})
			.append("g")
			.attr("transform","translate("+@size.width/2+","+@size.height/2+")");
		
		arc = d3.svg.arc()
				.outerRadius(@radius)
				.innerRadius(@innerRadius);
		pie = d3.layout.pie()
				.sort(null)
				.value((d)->
					return d);
		g = svg.selectAll(".fan")
				.data(pie(data))
				.enter()
				.append("g")
				.attr("class", "fan");
		
		g.append("path")
			.attr({
				d:arc,
				fill:(d,i)=>
					return @getRandomColor(d.value)
				,
				stroke:"black",
				"stroke-width":"2"
			});
		g.append("text")
		.attr(
			"transform",(d)->
				return "translate(" + arc.centroid(d) + ")"
			)
		.style("text-anchor", "middle")
		.text((d)->
				return d.value);
		
		
	test:->
		console.log @generateData()
obj = new MyD3()
obj.bowGraph()
obj.circleGraph()