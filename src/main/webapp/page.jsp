<%--
  Created by IntelliJ IDEA.
  User: yanzhenwei
  Date: 2019/9/27
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>两个DIV并排</title>
    <style>
        .div-c{ float:left;width:49%;height:500px;background-color:darkseagreen;   border:1px solid #F00}
        .div-d{ float:right;width:49%;height:500px;background-color:greenyellow; border:1px solid #000}

    </style>
    <script src="js/jquery-1.12.4.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <style type="text/css">
        @font-face{
            font-family: 'ITV Reem';
            src: url(assets/itvreem.woff) format('woff');
        }
        .js-odoo{
            width: 600px;
            margin: 50px auto;
            font-family: 'ITV Reem';
            font-size: 82px;
            text-shadow: 1px 1px 5px rgba(0,0,0,0.5);
            fill: #fff;
        }

        .js-odoo2{
            width: 600px;
            margin: 50px auto;
            font-family: 'ITV Reem';
            font-size: 82px;
            text-shadow: 1px 1px 5px rgba(0,0,0,0.5);
            fill: #fff;
        }
    </style>


    <script>


        $(function(){

            odoo.default({ el:'.js-odoo',value:'1238127312' })

            odoo.default({ el:'.js-odoo2',value:'￥8888' })


            $("#btn01").click(function(){
                var money = $("#money01").val();
                $.get("zhuang/1/2/"+money,function(data){
                    if(data=='success'){


                        var fromMoney = eval($("#fromMoney").text() - money);

                        $("#fromMoney").text(fromMoney);


                        var toMoney = parseInt($("#toMoney").text()) + parseInt(money);

                        $("#toMoney").text(toMoney);


                        var video = document.getElementById("myaudio");
                        video.play();
                    }
                });
            });

            $("#btn02").click(function(){
                var money = $("#money02").val();
                $.get("zhuang/2/1/"+money,function(data){
                    if(data=='success'){
                        var fromMoney = parseInt($("#fromMoney").text()) + parseInt(money);

                        $("#fromMoney").text(fromMoney);


                        var toMoney = parseInt($("#toMoney").text()) - parseInt(money);

                        $("#toMoney").text(toMoney);

                        document.getElementById("myaudio").play();
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="div-c" style="text-align:center;font-size: 30px;">

    <span>${accountList[0].name}</span> <br/>

    <div class="js-odoo"></div>

    <span id="fromMoney">${accountList[0].money}</span> <br/>
    <span>请输入转账金额：<input id="money01" name="money" type="number"></span> <br/>
    <span><input type="button" id="btn01" value="转账给${accountList[1].name}" /></span>
</div>
<div class="div-d" style="text-align: center;font-size: 30px">
    <span>${accountList[1].name}</span> <br/>

    <div class="js-odoo2"></div>

    <span id="toMoney">${accountList[1].money}</span> <br/>
    <span>请输入转账金额：<input id="money02" name="money" type="number"></span> <br/>
    <span><input type="button" id="btn02" value="转账给${accountList[0].name}" /></span>
</div>

<audio src="music.wav" id="myaudio" controls="controls" hidden="true">

</audio>
<script src="lib/odoo.js"></script>
</body>
</html>
