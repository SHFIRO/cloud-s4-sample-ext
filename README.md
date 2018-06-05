# S/4HANA Cloud extensions - Product ordering sample app (Spring framework)
This sample web application showcases an extension to an SAP S/4HANA Cloud system. It lists products (from the material master) for external users and allows to order them (i.e. a sales order is created in S/4HANA Cloud).

> **NOTE:** This sample app is based on and explained in detail in the [1RW set-up instructions guide](https://rapid.sap.com/bp/#/browse/scopeitems/1RW). There, you will find more details on the end to end steps of the ordering scenario example, e.g.:
> * Creation of a custom business object in SAP S/4HANA Cloud
> * Connection setup of the SAP S/4HANA Cloud system and SAP Cloud Platform (via a communication arrangement)
> * Adaption and deployment of the sample app

> The following README only shows a basic overview.


Requirements
-------------
1. We assume that you have access to an SAP S/4HANA Cloud system and an SAP Cloud Platform account
2. Install [JDK8](http://www.oracle.com/technetwork/java/javase/downloads/index.html), [Maven](http://maven.apache.org/download.cgi) and [Git](https://git-scm.com/downloads).
3. Prepare your S/4HANA Cloud system according to the [1RW set-up instructions guide](https://rapid.sap.com/bp/#/browse/scopeitems/1RW).
**Note:** to access the guide you need to have [an account for SAP Service Marketplace](https://websmp103.sap-ag.de/~sapidp/012002523100007691892016E/)

Download the sample app
------------------

```
git clone https://github.com/SAP/cloud-s4-sample-ext.git
cd cloud-s4-sample-ext
git checkout extorderapp-spring
```
Or if you want to clone the single branch only: 
```
git clone -b extorderapp-spring --single-branch git://github.com/SAP/cloud-s4-sample-ext.git
cd cloud-s4-sample-ext
```


Connect it to your S/4HANA Cloud system
---------------------------------------
Adapt [src/main/resources/application.properties](src/main/resources/application.properties) and adjust the connection parameters according to your SAP S/4HANA Cloud system.


```
# Base URL of the S/4HANA Cloud System
s4cld.api_host=https://myXXXXXX-api.s4hana.ondemand.com

# API User (to be maintained in the Communication System in S/4HANA Cloud)
s4cld.api_user=EXTORDERD_API_USER

# API Password
s4cld.api_pass=QGRlcl9tYXRoaWFz

# OData service of the Custom Business Object, created in S/4HANA Cloud to store one-time order data
s4cld.onetimecustomerrecord_servicepath=/sap/opu/odata/sap/YY1_CUSTOMERRECORD_CDS
s4cld.onetimecustomerrecord_resource=YY1_CUSTOMERRECORD
```


Build it
--------

```
mvn package
```


Deploy to SAP Cloud Platform
----------------------------
1. Login to your SAP Cloud Platform cockpit (trial available https://cloudplatform.sap.com).
2. Goto "Java Applications".
3. Select the freshly built `extorderapp-spring-0.0.1-SNAPSHOT.war` which was created by `the mvn` package command in folder `target`.
4. Choose `Java Web Tomcat 7` (runtime `JRE7`).


Limitations / Disclaimer
------------------------
Note: This sample code is primarily for illustration purposes and is not intended for productive usage. It solely shows basic interaction with an S/4HANA Cloud system. Topics like authentication, error handling, transactional correctness, security, caching, tests were omitted on purpose for the sake of simplicity. For detailed information on development on the SAP Cloud Platform, please consult https://cloudplatform.sap.com/developers.html


Known Issues
------------
This sample application reads data from the SAP S/4HANA Cloud backend system and hence requires appropriate data maintained for a sell from stock process. Further details can be found also in guide [Sell from stock BD9](https://rapid.sap.com/bp/#/browse/scopeitems/BD9).

If you work with your [SAP Cloud Platform Trial account](https://account.hanatrial.ondemand.com/), you must add the following 2 properties to the destination so that the connection to SAP S/4HANA Cloud works:  

      proxyHost =	proxy-trial.od.sap.biz  
      proxyPort =	8080
    

How to obtain support
---------------------
File a message in the [SAP Support Launchpad](https://launchpad.support.sap.com/#/incident/create) under component `CA-GTF-FND`


### Copyright and License

Copyright (c) 2017 SAP SE or an SAP affiliate company. All rights reserved.
This file is licensed under the Apache Software License, v. 2 except as noted otherwise in the [LICENSE](LICENSE) file

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
