/*
 * Licensed under MIT (https://github.com/ligoj/ligoj/blob/master/LICENSE)
 */
callback({
   "vers":0.01,
   "config":{
      "rate":"perhr",
      "valueColumns":[
         "linux",
         "mswin"
      ],
      "currencies":[
         "USD"
      ],
      "regions":[
         {
            "region":"us-east",
            "footnotes":{
               "*":"notAvailableForCCorCGPU"
            },
            "instanceTypes":[
               {
                  "type":"generalCurrentGen",
                  "sizes":[
                     {
                        "size":"m3.medium",
                        "valueColumns":[
                           {
                              "name":"linux",
                              "prices":{
                                 "USD":"0.0127"
                              }
                           }
                        ]
                     }
                    ]
               }
           ]
         },
         {
            "region":"eu-ireland",
            "footnotes":{
               "*":"notAvailableForCCorCGPU"
            },
            "instanceTypes":[
               {
                  "type":"computePreviousGen",
                  "sizes":[
                     {
                        "size":"c1.medium",
                        "valueColumns":[
                           {
                              "name":"linux",
                              "prices":{
                                 "USD":"0.0284"
                              }
                           },
                           {
                              "name":"mswin",
                              "prices":{
                                 "USD":"0.096"
                              }
                           }
                        ]
                     }
                  ]
               },
               {
                  "type":"hiMemCurrentGen",
                  "sizes":[
                     {
                        "size":"x1.16xlarge",
                        "valueColumns":[
                           {
                              "name":"linux",
                              "prices":{
                                 "USD":"1.4553"
                              }
                           },
                           {
                              "name":"mswin",
                              "prices":{
                                 "USD":"N/A*"
                              }
                           }
                        ]
                     },
                     {
                        "size":"r4.large",
                        "valueColumns":[
                           {
                              "name":"linux",
                              "prices":{
                                 "USD":"0.0173"
                              }
                           },
                           {
                              "name":"mswin",
                              "prices":{
                                 "USD":"0.1061"
                              }
                           }
                        ]
                     }
                  ]
               }
            ]
         },
         {
            "region":"eu-central-1",
            "footnotes":{
               "*":"clusterOnlyInUSEast"
            },
            "instanceTypes":[
            ]
         }
      ]
   }
});