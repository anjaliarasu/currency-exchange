# Crewmeister Test Assignment - Java Backend Developer

## Intro
Thank you for taking the time to complete this challenge as part of your application at Crewmeister!
We are taking development skills very serious and invest a lot of time to find the right candidate. 

At Crewmeister we aim to write excellent software and are convinced that this requires a high level of passion for and 
attention to topics such as software design and principles, best practices and clean code. We take pride in the fact
that the code we produce is extensible, testable, maintainable and runs fast.  

At the same time, we always try to improve the effectiveness of our evaluation and improve the candidate journey
throughout the process. Our aim is that our hiring process is mutually inspiring and feels like a gain for
both parties regardless of the outcome. If you feel to give us feedback on that, please don't hesitate to do so. 

## The Challenge

Your task is to create a foreign exchange rate service as SpringBoot-based microservice. 

The exchange rates can be received from [2]. This is a public service provided by the German central bank.

As we are using user story format to specify our requirements, here are the user stories to implement:

- As a client, I want to get a list of all available currencies
- As a client, I want to get all EUR-FX exchange rates at all available dates as a collection
- As a client, I want to get the EUR-FX exchange rate at particular day
- As a client, I want to get a foreign exchange amount for a given currency converted to EUR on a particular day

If you think that your service would require storage, please use H2 for simplicity, even if this would not be your choice if 
you would implement an endpoint for real clients. 

We are looking out for the following aspects in your submission:
- Well structured and thought-through api and endpoint design 
- Clean code
- Application of best practices & design patterns


That being said it is not enough to "just make it work", show your full potential to write excellent software
 for Crewmeister ! 
 
## Setup
#### Requirements
- Java 11 (will run with OpenSDK 15 as well)
- Maven 3.x

#### Project
The project was generated through the Spring initializer [1] for Java
 11 with dev tools and Spring Web as dependencies. In order to build and 
 run it, you just need to click the green arrow in the Application class in your Intellij 
 CE IDE or run the following command from your project root und Linux or ios. 

````shell script
$ mvn spring-boot:run
````

After running, the project, switch to your browser and hit http://localhost:8080/api/currencies. You should see some 
demo output. 


[1] https://start.spring.io/

[2] [Bundesbank Daily Exchange Rates](https://www.bundesbank.de/dynamic/action/en/statistics/time-series-databases/time-series-databases/759784/759784?statisticType=BBK_ITS&listId=www_sdks_b01012_3&treeAnchor=WECHSELKURSE)


DB setup:

DB is setup using h2. Which can be found in test.mv file. It's loaded with few datas from [2].

API-Information to get results:

####Scenario-As a client, I want to get a list of all available currencies

Get call->http://localhost:8080/api/currencies

Output: [
    "GBP",
    "SGD",
    "USD"
]
####Scenario-As a client, I want to get all EUR-FX exchange rates at all available dates as a collection

Get call->http://localhost:8080/api/allExchangeRates

This gives results for each available dates as a collection

output:
{
    "2021-01-11T18:30:00.000+00:00": [
        {
            "id": 5,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-01-12",
            "rate": 1.5431
        },
        {
            "id": 45,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-01-12",
            "rate": 1.1314
        },
        {
            "id": 64,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-01-12",
            "rate": 0.85
        }
    ],
    "2021-11-30T18:30:00.000+00:00": [
        {
            "id": 37,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-01",
            "rate": 1.418
        },
        {
            "id": 42,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-01",
            "rate": 1.418
        },
        {
            "id": 52,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-01",
            "rate": 1.0366
        },
        {
            "id": 61,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-01",
            "rate": 1.0366
        },
        {
            "id": 71,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-12-01",
            "rate": 0.85715
        }
    ],
    "2021-11-28T18:30:00.000+00:00": [
        {
            "id": 35,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-11-29",
            "rate": 1.4237
        },
        {
            "id": 40,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-11-29",
            "rate": 1.4237
        },
        {
            "id": 50,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-11-29",
            "rate": 1.0366
        },
        {
            "id": 59,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-11-29",
            "rate": 1.0366
        },
        {
            "id": 69,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-11-29",
            "rate": 0.86218
        }
    ],
    "2021-03-11T18:30:00.000+00:00": [
        {
            "id": 33,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-03-12",
            "rate": 1.5466
        },
        {
            "id": 47,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-03-12",
            "rate": 1.1291
        },
        {
            "id": 56,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-03-12",
            "rate": 1.1291
        },
        {
            "id": 66,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-03-12",
            "rate": 0.85048
        }
    ],
    "2021-11-29T18:30:00.000+00:00": [
        {
            "id": 36,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-11-30",
            "rate": 1.5501
        },
        {
            "id": 41,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-11-30",
            "rate": 1.5501
        },
        {
            "id": 51,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-11-30",
            "rate": 1.0376
        },
        {
            "id": 60,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-11-30",
            "rate": 1.0376
        },
        {
            "id": 70,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-11-30",
            "rate": 0.86488
        }
    ],
    "2021-02-11T18:30:00.000+00:00": [
        {
            "id": 39,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-02-12",
            "rate": 1.4227
        },
        {
            "id": 44,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-02-12",
            "rate": 1.4227
        },
        {
            "id": 46,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-02-12",
            "rate": 1.1339
        },
        {
            "id": 54,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-02-12",
            "rate": 1.0538
        },
        {
            "id": 55,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-02-12",
            "rate": 1.1339
        },
        {
            "id": 63,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-02-12",
            "rate": 1.0538
        },
        {
            "id": 65,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-02-12",
            "rate": 0.85135
        }
    ],
    "2021-06-11T18:30:00.000+00:00": [
        {
            "id": 48,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-06-12",
            "rate": 1.1287
        },
        {
            "id": 57,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-06-12",
            "rate": 1.1287
        },
        {
            "id": 67,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-06-12",
            "rate": 0.85128
        }
    ],
    "2021-07-11T18:30:00.000+00:00": [
        {
            "id": 34,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-07-12",
            "rate": 1.538
        },
        {
            "id": 49,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-07-12",
            "rate": 1.1256
        },
        {
            "id": 58,
            "fromCurrency": "EUR",
            "toCurrency": "USD",
            "exchdate": "2021-07-12",
            "rate": 1.1256
        },
        {
            "id": 68,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-07-12",
            "rate": 0.84933
        }
    ],
    "2021-12-01T18:30:00.000+00:00": [
        {
            "id": 38,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-02",
            "rate": 1.4195
        },
        {
            "id": 43,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-02",
            "rate": 1.4195
        },
        {
            "id": 53,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-02",
            "rate": 1.0454
        },
        {
            "id": 62,
            "fromCurrency": "EUR",
            "toCurrency": "SGD",
            "exchdate": "2021-12-02",
            "rate": 1.0454
        },
        {
            "id": 72,
            "fromCurrency": "EUR",
            "toCurrency": "GBP",
            "exchdate": "2021-12-02",
            "rate": 0.85855
        }
    ]
}


####Scenario-As a client,I want to get the EUR-FX exchange rate at particular day

Get call->http://localhost:8080/api/getExchangeRatesByDate/2021-01-12?toCurrency=SGD

Output: 1.5431

####Scenario-As a client, I want to get a foreign exchange amount for a given currency converted to EUR on a particular day

Post call -> http://localhost:8080/api/getExchangeAmountByDate

Body: {
    "date":"2021-01-12",
    "currency":"SGD",
    "currenciesToConvert":3
}

Output: 1.94

For each Api's proper object oriented design is done and exception handling is done considering all scenarios.

For Example: 

http://localhost:8080/api/getExchangeAmountByDate

Body: {
   
    "currency":"SGD",
    "currenciesToConvert":3
}

if date is not passed, it will send below response

{
    "timestamp": "2022-12-08T13:20:42.877+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "trace": "javax.validation.ConstraintViolationException: Parameters not valid\r\n\tat com.crewmeister.cmcodingchallenge.controller.CurrencyController.getExchangeAmountByDate(CurrencyController.java:81)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:568)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:894)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)\r\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1061)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:961)\r\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\r\n\tat org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:652)\r\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:733)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\r\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\r\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)\r\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542)\r\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143)\r\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\r\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)\r\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\r\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374)\r\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\r\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:888)\r\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1597)\r\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\r\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)\r\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)\r\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n\tat java.base/java.lang.Thread.run(Thread.java:833)\r\n",
    "message": "Parameters not valid",
    "path": "/api/getExchangeAmountByDate"
}
