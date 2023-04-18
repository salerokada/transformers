# Transformer Service

Transformer service is application created for input string processing based on the transformer rules that comes in a
request together with string literal.
Application supports three types of transformer:

* REMOVAL
* REPLACEMENT
* TRANSLITERATION

### REMOVAL ###

REMOVAL transformer should come with one parameter which contains regex. That regex will be applied to remove matches
from string literal.

### REPLACEMENT ###

REPLACEMENT transformer should have two parameter along. First is regex, second is replacement value. Regex will find
matches in literal and replace them with replacement parameter.

### TRANSLITERATION ###

TRANSLITERATION transformer detect Cyrillic and Greek letters in given value and convert those letters to Latin.

## Request format ##

Request should look like:

```
{
    "elements":
    [
        {
            "value": "This is some Random Text",
            "transformers":
            [
                {
                    "group": "group1",
                    "transformerId": "t1",
                    "parameters":
                    [
                        "PARAM1",
                        "PARAM2"
                    ]
                },
                {
                    "group": "group1",
                    "transformerId": "t1",
                    "parameters":
                    [
                        "PARAM1",
                        "PARAM2"
                    ]
                }
            ]
        },
        {
            ...,
            ...
        }
    ]
}
```

## Response format ##

Response is in the format:

```
{
    "elements":
    [
        {
            "original": "Текст то цонверт",
            "transformed": "Tekst to convert"
        },
        {
            ...
            ...
        }
    ]
}
```

### Swagger documentation ###

Can be found on [http://{host}/swagger-ui/index.html](http://host/swagger-ui/index.html).
For localhost different port is defined at [application-development.properties]

#### Author ####

Saša Obradović / Саша Обрадовић
