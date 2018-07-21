<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加用户</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame//static/image/code.png">
    <style>
        .layui-margin-top {
            margin-top: 20px;
        }
    </style>
</head>
<body class="body">
<div class="layui-container layui-margin-top">
    <div class="layui-row">
        <div class="layui-col-md12">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>新增用户</legend>
            </fieldset>

            <form class="layui-form layui-form-pane" action="/user/add" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">登录名</label>
                    <div class="layui-input-block">
                        <input type="text" name="loginName" required  lay-verify="required" placeholder="请输入登录名" autocomplete="off" class="layui-input">
                        <div class="layui-form-mid layui-word-aux"></div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input type="password"  name="loginPassword" id="loginPassword" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="confirmPwd" lay-verify="confirmPwd" placeholder="请输入确认密码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">真实姓各</label>
                    <div class="layui-input-block">
                        <input type="text" name="userName" placeholder="请输入真实姓各" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-block">
                        <input type="text" name="mobile" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux"></div>
                </div>

                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-block">
                        <input checked="" name="isAvailable" lay-skin="switch" lay-filter="switchTest" title="是否可用" type="checkbox">
                    </div>
                </div>

                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn" id="btnUpload">
                            <i class="layui-icon">&#xe67c;</i>上传头像
                        </button>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">文本域</label>
                    <div class="layui-input-block">
                        <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" width="50" height="50" id="headImg">
                        <input type="hidden" name="headImgPath" id="headImgPath" />
                    </div>
                </div>
                <div class="layui-form-item layui-hide">
                    <button class="layui-btn" lay-submit lay-filter="btnCommit" id="btnCommit">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="/frame/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate', 'element', 'upload'], function () {
        var form = layui.form
            , layer = layui.layer
            , upload = layui.upload
            , $ = layui.jquery;

        //自定义验证规则
        form.verify({
            confirmPwd: function(value){
                var pwd = $("#loginPassword").val();
                if(value != pwd){
                    return '密码不一致';
                }
            }

        });

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#btnUpload'
            ,url: '/image/upload'
            ,acceptMime: 'image/png'
            ,exts: 'png'
            ,field: 'file'
            ,before: function(obj){
                layer.load(); //上传loading
            }
            ,done: function(res, index, upload){
                //如果上传失败
                if(res.code != 200){
                    return layer.msg(res.msg);
                }
                //上传成功
                var imagePath = res.data;
                $("#headImg").attr("src",imagePath);
                $("#headImgPath").val(imagePath);//上传路径
                layer.closeAll('loading'); //关闭loading
            }
            ,error: function(){
                layer.closeAll('loading'); //关闭loading
            }
        });

    });
</script>
</body>
</html>
