package com.thisisentropy.remarkablesdk;


public class JsonTests {
    private static String test1 = "{\"status\":\"OK\",\"status_code\":200,\"message\":\"\",\"release_name\":\"New Release\",\"bundle_version\":\"1\",\"last_update\":\"2015-02-28T16:02:40.058+00:00\",\"last_update_timestamp\":1425139360,\"payload\":{\"about\":{\"introduction\":\"Introduction test\",\"image\":\"https://res.useremarkable.com/items/files/54f1/e5be/6336/6300/1433/0000/original/first_shot.png?1425139127\",\"sections\":[{\"title\":\"About menu item\",\"description\":\"desc\",\"image\":\"https://res.useremarkable.com/items/files/54f1/e5be/6336/6300/1433/0000/original/first_shot.png?1425139127\"}]},\"data_array\":[{\"title\":\"dsfdsfdf\",\"detail\":\"dfdsfdsfdsfsd\",\"sections\":[{\"text\":\"fdsfdfsdf\",\"summary\":\"fsdfdsfsfdfdsfdsf\"}]}],\"external_links\":[]}}";
    private static String test2 = "{\"response\":[\n" +
            "    {\n" +
            "        \"_id\": \"54f7690d6b5aa702285ad334\",\n" +
            "            \"index\": 0,\n" +
            "            \"guid\": \"d317df82-ca78-41aa-bdc3-e27aeca1c43a\",\n" +
            "            \"isActive\": false,\n" +
            "            \"balance\": \"$1,457.83\",\n" +
            "            \"picture\": \"http://assets.worldwildlife.org/photos/1620/images/carousel_small/bengal-tiger-why-matter_7341043.jpg\",\n" +
            "            \"age\": 26,\n" +
            "            \"eyeColor\": \"blue\",\n" +
            "            \"name\": \"Sampson Sawyer\",\n" +
            "            \"gender\": \"male\",\n" +
            "            \"company\": \"CENTREE\",\n" +
            "            \"email\": \"sampsonsawyer@centree.com\",\n" +
            "            \"phone\": \"+1 (805) 518-3883\",\n" +
            "            \"address\": \"753 Milford Street, Greer, Pennsylvania, 9262\",\n" +
            "            \"about\": \"Nulla fugiat mollit ex fugiat officia ex sint commodo sint nulla velit. Nostrud incididunt proident deserunt cillum. Commodo culpa reprehenderit elit labore proident non ipsum aliqua ut dolore non deserunt. Nostrud officia sunt voluptate ex nisi.\\r\\n\",\n" +
            "            \"registered\": \"2014-06-17T20:54:58 -01:00\",\n" +
            "            \"latitude\": 30.829651,\n" +
            "            \"longitude\": 23.174263,\n" +
            "            \"tags\": [\n" +
            "        \"commodo\",\n" +
            "                \"ullamco\",\n" +
            "                \"proident\",\n" +
            "                \"nulla\",\n" +
            "                \"quis\",\n" +
            "                \"eu\",\n" +
            "                \"in\"\n" +
            "        ],\n" +
            "        \"friends\": [\n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "                \"name\": \"Cooke Foster\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "                \"name\": \"Dixon Jennings\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "                \"name\": \"Hayes Workman\"\n" +
            "        }\n" +
            "        ],\n" +
            "        \"greeting\": \"Hello, Sampson Sawyer! You have 4 unread messages.\",\n" +
            "            \"favoriteFruit\": \"banana\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"54f7690dda549822ba64554b\",\n" +
            "            \"index\": 1,\n" +
            "            \"guid\": \"92bb101b-8fcf-40b8-97f7-d624981ece62\",\n" +
            "            \"isActive\": true,\n" +
            "            \"balance\": \"$3,336.23\",\n" +
            "            \"picture\": \"http://placehold.it/32x32\",\n" +
            "            \"age\": 32,\n" +
            "            \"eyeColor\": \"blue\",\n" +
            "            \"name\": \"Adams Levy\",\n" +
            "            \"gender\": \"male\",\n" +
            "            \"company\": \"KONGENE\",\n" +
            "            \"email\": \"adamslevy@kongene.com\",\n" +
            "            \"phone\": \"+1 (937) 436-3988\",\n" +
            "            \"address\": \"990 Main Street, Lisco, Guam, 3132\",\n" +
            "            \"about\": \"Laboris cillum enim nulla duis eiusmod ea et est adipisicing fugiat fugiat pariatur occaecat. Excepteur exercitation sunt ipsum voluptate veniam occaecat. Ex consequat qui laboris voluptate nulla laboris occaecat officia esse duis deserunt. Fugiat in Lorem aute adipisicing. Fugiat sint velit elit do.\\r\\n\",\n" +
            "            \"registered\": \"2015-01-21T02:30:52 -00:00\",\n" +
            "            \"latitude\": -60.080617,\n" +
            "            \"longitude\": 115.317426,\n" +
            "            \"tags\": [\n" +
            "        \"deserunt\",\n" +
            "                \"voluptate\",\n" +
            "                \"reprehenderit\",\n" +
            "                \"occaecat\",\n" +
            "                \"non\",\n" +
            "                \"tempor\",\n" +
            "                \"quis\"\n" +
            "        ],\n" +
            "        \"friends\": [\n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "                \"name\": \"Sutton Osborn\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "                \"name\": \"Paige Gregory\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "                \"name\": \"Leona Peck\"\n" +
            "        }\n" +
            "        ],\n" +
            "        \"greeting\": \"Hello, Adams Levy! You have 3 unread messages.\",\n" +
            "            \"favoriteFruit\": \"strawberry\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"54f7690d328f2fc003b1cbf3\",\n" +
            "            \"index\": 2,\n" +
            "            \"guid\": \"6ae1e290-1441-4095-b945-d6a2a330cbc7\",\n" +
            "            \"isActive\": true,\n" +
            "            \"balance\": \"$1,470.20\",\n" +
            "            \"picture\": \"http://placehold.it/32x32\",\n" +
            "            \"age\": 38,\n" +
            "            \"eyeColor\": \"green\",\n" +
            "            \"name\": \"Audrey Slater\",\n" +
            "            \"gender\": \"female\",\n" +
            "            \"company\": \"ASSISTIX\",\n" +
            "            \"email\": \"audreyslater@assistix.com\",\n" +
            "            \"phone\": \"+1 (984) 411-3545\",\n" +
            "            \"address\": \"411 Cypress Court, Whitehaven, Virginia, 8735\",\n" +
            "            \"about\": \"Voluptate ullamco anim sunt id voluptate proident consectetur. Nostrud eiusmod quis magna consectetur est laborum laboris ullamco consectetur duis est. Labore veniam veniam aute commodo dolore est laboris. Ut laboris incididunt do cillum enim amet culpa voluptate Lorem culpa aute laborum. Laboris consequat pariatur pariatur aliquip id ad culpa. Deserunt aliqua aliquip excepteur officia non Lorem ea nisi enim enim dolor veniam officia. Aliquip Lorem ad cillum dolor.\\r\\n\",\n" +
            "            \"registered\": \"2014-04-19T19:28:16 -01:00\",\n" +
            "            \"latitude\": -84.831477,\n" +
            "            \"longitude\": 164.736579,\n" +
            "            \"tags\": [\n" +
            "        \"id\",\n" +
            "                \"ea\",\n" +
            "                \"proident\",\n" +
            "                \"eiusmod\",\n" +
            "                \"officia\",\n" +
            "                \"pariatur\",\n" +
            "                \"adipisicing\"\n" +
            "        ],\n" +
            "        \"friends\": [\n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "                \"name\": \"Kinney Zamora\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "                \"name\": \"Candace Cannon\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "                \"name\": \"Coleen Cabrera\"\n" +
            "        }\n" +
            "        ],\n" +
            "        \"greeting\": \"Hello, Audrey Slater! You have 8 unread messages.\",\n" +
            "            \"favoriteFruit\": \"banana\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"54f7690d00a148d5d395139c\",\n" +
            "            \"index\": 3,\n" +
            "            \"guid\": \"123f019d-7484-46d2-b19e-6b5558aa0703\",\n" +
            "            \"isActive\": true,\n" +
            "            \"balance\": \"$2,651.57\",\n" +
            "            \"picture\": \"http://placehold.it/32x32\",\n" +
            "            \"age\": 40,\n" +
            "            \"eyeColor\": \"brown\",\n" +
            "            \"name\": \"Elena Parsons\",\n" +
            "            \"gender\": \"female\",\n" +
            "            \"company\": \"PARAGONIA\",\n" +
            "            \"email\": \"elenaparsons@paragonia.com\",\n" +
            "            \"phone\": \"+1 (945) 422-2831\",\n" +
            "            \"address\": \"176 Kansas Place, Conestoga, Wyoming, 6024\",\n" +
            "            \"about\": \"Commodo ut id ad reprehenderit dolore. Labore labore proident enim eu. Dolore proident Lorem consectetur excepteur sint ex est velit nisi ipsum. Deserunt qui aliqua proident minim ad id excepteur ullamco et et. Veniam fugiat esse cillum eu.\\r\\n\",\n" +
            "            \"registered\": \"2014-01-10T11:07:17 -00:00\",\n" +
            "            \"latitude\": 85.022477,\n" +
            "            \"longitude\": -137.238858,\n" +
            "            \"tags\": [\n" +
            "        \"ullamco\",\n" +
            "                \"ex\",\n" +
            "                \"mollit\",\n" +
            "                \"minim\",\n" +
            "                \"nisi\",\n" +
            "                \"sit\",\n" +
            "                \"pariatur\"\n" +
            "        ],\n" +
            "        \"friends\": [\n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "                \"name\": \"Olsen Contreras\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "                \"name\": \"Carpenter Cooley\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "                \"name\": \"Roberson Sampson\"\n" +
            "        }\n" +
            "        ],\n" +
            "        \"greeting\": \"Hello, Elena Parsons! You have 4 unread messages.\",\n" +
            "            \"favoriteFruit\": \"banana\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"_id\": \"54f7690dcae7b39d07c78b2e\",\n" +
            "            \"index\": 4,\n" +
            "            \"guid\": \"4b456dab-74e9-4a4e-b60d-a59f2c5c8ee9\",\n" +
            "            \"isActive\": false,\n" +
            "            \"balance\": \"$2,614.44\",\n" +
            "            \"picture\": \"http://placehold.it/32x32\",\n" +
            "            \"age\": 39,\n" +
            "            \"eyeColor\": \"blue\",\n" +
            "            \"name\": \"Golden Villarreal\",\n" +
            "            \"gender\": \"male\",\n" +
            "            \"company\": \"PHARMEX\",\n" +
            "            \"email\": \"goldenvillarreal@pharmex.com\",\n" +
            "            \"phone\": \"+1 (954) 447-2034\",\n" +
            "            \"address\": \"700 Prospect Place, Marbury, New Jersey, 9164\",\n" +
            "            \"about\": \"Qui dolore non proident eiusmod occaecat consequat labore Lorem. Sunt enim ullamco amet nisi aliqua sit. Ex minim ut amet laborum veniam. Elit exercitation anim consequat reprehenderit cillum nulla adipisicing id laboris ipsum ex excepteur veniam. Non exercitation consequat deserunt cillum ut consectetur. Proident labore id et pariatur irure irure est incididunt eu ullamco occaecat ut. Ad ipsum sint tempor aliqua deserunt.\\r\\n\",\n" +
            "            \"registered\": \"2014-11-27T09:26:04 -00:00\",\n" +
            "            \"latitude\": -37.858393,\n" +
            "            \"longitude\": -18.710389,\n" +
            "            \"tags\": [\n" +
            "        \"laboris\",\n" +
            "                \"deserunt\",\n" +
            "                \"in\",\n" +
            "                \"Lorem\",\n" +
            "                \"anim\",\n" +
            "                \"nostrud\",\n" +
            "                \"tempor\"\n" +
            "        ],\n" +
            "        \"friends\": [\n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "                \"name\": \"Cohen Wooten\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "                \"name\": \"Traci Mcclure\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "                \"name\": \"Lee Church\"\n" +
            "        }\n" +
            "        ],\n" +
            "        \"greeting\": \"Hello, Golden Villarreal! You have 1 unread messages.\",\n" +
            "            \"favoriteFruit\": \"apple\"\n" +
            "    }\n" +
            "    ]}";
    
    
}
