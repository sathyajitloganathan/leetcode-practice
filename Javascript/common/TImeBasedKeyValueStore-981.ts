["TimeMap", "set",              "set",              "get",      "get",  "get",      "get",      "get"]
[[],        ["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]


Map(1) { 'love' => Map(2) { 10 => 'high', 20 => 'low' } }
Map(1) { 'love' => Map(2) { 10 => 'high', 20 => 'low' } }
Map(1) { 'love' => Map(2) { 10 => 'high', 20 => 'low' } }
Map(1) { 'love' => Map(2) { 10 => 'high', 20 => 'low' } }
Map(1) { 'love' => Map(2) { 10 => 'high', 20 => 'low' } }


Output 
[null,null,null,"low","high","low","low","low"]


Expected
[null,null,null,"","high","high","low","low"]