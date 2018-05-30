1.在app项目里面的build.gradle 添加以下配置，下面代码是替换AndroidManifest.xml的currentPackageName字符串为当前包名
   android.applicationVariants.all { variant ->
           variant.outputs[0].processManifest.doLast {
               def manifestFile = "${buildDir}/intermediates/manifests/full/${variant.outputs[0].dirName}/AndroidManifest.xml"
               def updatedContent = new File(manifestFile).getText('UTF-8')
                       .replaceAll("com.gatewang.jpushlib.","")
                       .replaceAll("currentPackageName", "${applicationId}")
                       .replaceAll("my_Receiver","广播接收者路径") //广播接收者路径
                       .replaceAll("my_jpush_appkey","极光appkey") //极光appkey
               new File(manifestFile).write(updatedContent, 'UTF-8')
           }
       }

注意： 可能找不到清单文件问题
  3.x 用 ${variant.dirName}
  3.0以下用 ${variant.outputs[0].dirName


 2.在app项目里面的Application进行初始化
                JPushClient.getInstance(this);
3.引入jpushlib只有按照上面2个步骤方可获得监听广播