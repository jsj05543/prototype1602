// Generated by CoffeeScript 1.10.0
(function() {
  var MyD3, obj;

  MyD3 = (function() {
    function MyD3() {}

    MyD3.prototype.size = {
      width: 500,
      height: 400
    };

    MyD3.prototype.lots = 10;

    MyD3.prototype.getGraphWidth = function() {
      console.log(this.size.width / this.lots);
      return this.size.width / this.lots;
    };

    MyD3.prototype.getRandomColor = function() {
      var b, g, r;
      r = Math.round((Math.random() * 255) + 1);
      g = Math.round((Math.random() * 255) + 1);
      b = Math.round((Math.random() * 255) + 1);
      return "rgb(" + r + "," + g + "," + b + ")";
    };

    MyD3.prototype.generateData = function() {
      var i, j, list, maxValue, ref;
      maxValue = this.size.height;
      list = [];
      for (i = j = 1, ref = this.lots; 1 <= ref ? j < ref : j > ref; i = 1 <= ref ? ++j : --j) {
        list.push(Math.round(Math.random() * maxValue));
      }
      return list;
    };

    MyD3.prototype.bowGraph = function() {
      var data, svg;
      data = this.generateData();
      svg = d3.select("#bowGraph").append("svg");
      svg.attr({
        width: this.size.width,
        height: this.size.height
      });
      svg.selectAll("rect").data(data).enter().append('rect').attr({
        x: (function(_this) {
          return function(d, i) {
            return i * _this.getGraphWidth();
          };
        })(this),
        y: (function(_this) {
          return function(d) {
            return _this.size.height - d;
          };
        })(this),
        width: (function(_this) {
          return function(d) {
            return _this.getGraphWidth();
          };
        })(this),
        height: function(d) {
          return d;
        },
        fill: (function(_this) {
          return function() {
            return _this.getRandomColor();
          };
        })(this),
        stroke: "rgb(0,0,0)"
      });
      svg.selectAll("text").data(data).enter().append("text").attr({
        x: (function(_this) {
          return function(d, i) {
            return (i * _this.getGraphWidth()) + (_this.getGraphWidth() / 2);
          };
        })(this),
        y: (function(_this) {
          return function(d, i) {
            return _this.size.height - d + 20;
          };
        })(this)
      }).text(function(d) {
        return d;
      });
    };

    MyD3.prototype.circleGraph = function(data) {
      var svg;
      svg = d3.select("#circleGraph").append("svg");
      return svg.attr({
        width: this.size.width,
        height: this.size.height
      });
    };

    MyD3.prototype.test = function() {
      return console.log(this.generateData());
    };

    return MyD3;

  })();

  obj = new MyD3();

  obj.bowGraph();

  obj.circleGraph();

}).call(this);
