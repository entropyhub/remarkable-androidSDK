# remarkable-androidSDK

To use this library, simply:

1: Download the AAR file <a href="https://github.com/entropyhub/remarkable-androidSDK/releases/download/1.0.1/RemarkableSDK-1.0.1.aar">HERE</a> and copy into your 'libs' folder.


2: Add the following to your apps /myproject/build.gradle file

      flatDir 
      {
          dirs 'libs'
      }
      
Which should look something like this:
              
      allprojects {
          repositories {
              flatDir {
                  dirs 'libs'
              }
      
          }
      }
      
3: Finally, add the following to your projects app/build.gradle file

      compile(name:'RemarkableSDK-1.0.0', ext:'aar')

Which should look something like this:

      dependencies {
          //Your other dependencies
          compile(name:'RemarkableSDK-1.0.0', ext:'aar')
      }
