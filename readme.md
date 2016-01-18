#
[toc]

##�½�Project
�½�Projectȡ��UseOfSmall

##����Project�µ�build.gradle
1. �ڹ����ϰ�`F4`��`ProjectStructure`���޸�`Project`�µ�`Gradle version`Ϊ`2.9`
1. ��dependencies������һ��`classpath 'net.wequick.tools.build:gradle-small:0.1.1'`
1. ���ļ��������һ������
 ```
 apply plugin: 'net.wequick.small'
 small {
     aarVersion = '0.1.2'
 }
 ```

##����`app`module
1. ���Ѿ������õ�`app`module������build.gradle
 ��buildTypes���棨android�£�������´���
 ```
 // Filter locale configuration
 aaptOptions {
     additionalParameters '-c', 'zh-rCN'
 }

 // Signing
 signingConfigs {
     release {
         storeFile file('../sign/release.jks')
         storePassword "5mall@ndro!d"
         keyAlias "small"
         keyPassword "5mall@ndro!d"
     }
 }
 buildTypes {
     release {
         signingConfig signingConfigs.release
     }
 }
 ```
1. ����ǩ���ļ�
 ��Sample����Ŀ¼�µ�sign�ļ��п������˹���
1. ��дApplication.java
 �˴��½�һ��App��̳�Application����дonCreate��������
 ```
 public class App extends Application{
     @Override
     public void onCreate() {
         super.onCreate();
         Small.setBaseUri("http://m.wequick.net/demo/");
     }
 }
 ```
 *�˴����������Project�µ�build.gradleʱ���������ã�����Ѿ����õ��gradle��ť����һ�¡�*
1. ����AndroidManifest.xml
 ��<application>��һ�����`android:name=".App"`(*AppΪ�ղ���д��Application��*)

##�½����module
1. �½�һ��module����ΪApp.*(��`App.`��ͷ��**ע����`.`**)
 �˴���Applicatio nameΪApp.Demo��
 �Զ���д��module name Ϊapp.demo��**ע��Module Name��Ҫ�޸�**
 �ֶ��޸İ���Ϊ����module�İ���+���module��ModuleName����
1. Ϊ����������һ��module���˴���`activity_main.xml`�е�TextView�ı���Ϊ��demo�������з��á�

##����app module
ע��������õ����Զ�������app module
1. �½�assets�ļ��У�Ĭ�ϴ����µ�moduleʱ�������ļ��У�
1. ��assets���½�bundles.json�ļ���Ҳ���Դ�Smaple�����п�����������д����
 ```
 {
   "version": "1.0.0",
   "bundles": [
     {
       "uri": "demo",//����Ǹ�app.demo��ı������������д
       "pkg": "com.xmh.useofsmall.app.demo"//�����app.demo�İ�������build.gradle�е�`applicationId`
     }
   ]
 }
 ```
1. ��app��MainActivity��onCreate����ӿ���app.demo�Ĵ���
 ```
 Small.setUp(this, new net.wequick.small.Bundle.OnLoadListener() {
     @Override
     public void onStart(int bundleCount, int upgradeBundlesCount, long upgradeBundlesSize) {
 
     }
 
     @Override
     public void onProgress(int bundleIndex, String bundleName, long loadedSize, long bundleSize) {
 
     }
 
     @Override
     public void onComplete(Boolean success) {
         Small.openUri("demo",MainActivity.this);
         finish();
     }
 });
 ```


##build����
�ⲿ�����ն�����ɣ�AndroidStudio�Դ�Terminal�նˡ�����Ҳ������԰���ݼ�`ctrl+shift+a`������`Terminal`�򿪡�
1. ����`gradlew buildLib`�س�
1. ����`gradlew buildBundle`�س�