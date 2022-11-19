import 'package:flutter/material.dart';

void main() {
  runApp(
    const MaterialApp(
      title: "Second App",
      home: MyApp(),
      debugShowCheckedModeBanner: false,
    ),
  );
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  TextEditingController txt1 = TextEditingController();
  TextEditingController txt2 = TextEditingController();
  TextEditingController res = TextEditingController();

  void operation(ope) {
    if (txt1.text == "" && txt2.text == "") {
      txt1.text = "0";
      txt2.text = "0";
    }
    int num1 = int.parse(txt1.text);
    int num2 = int.parse(txt2.text);
    int? num3;
    if (ope == "add") {
      num3 = num1 + num2;
    } else if (ope == "sub") {
      num3 = num1 - num2;
    } else if (ope == "mul") {
      num3 = num1 * num2;
    } else if (ope == "div") {
      num3 = (num1 ~/ num2).floor();
    }

    setState(() {
      res.text = num3.toString();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Cool App")),
      body: Container(
        padding: const EdgeInsets.all(30),
        child: Column(
          children: [
            TextField(
              controller: txt1,
              style: const TextStyle(
                fontSize: 20.0,
                fontWeight: FontWeight.bold,
              ),
              decoration: const InputDecoration(
                hintText: 'First Number',
                labelText: 'Enter the first number',
              ),
            ),
            TextField(
              controller: txt2,
              style: const TextStyle(
                fontSize: 20.0,
                fontWeight: FontWeight.bold,
              ),
              decoration: const InputDecoration(
                hintText: 'Second Number',
                labelText: 'Enter the second number',
              ),
            ),
            TextField(
              controller: res,
              style: const TextStyle(
                fontSize: 20.0,
                fontWeight: FontWeight.bold,
              ),
              enabled: false,
              decoration: const InputDecoration(
                hintText: 'Result',
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(10.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  TextButton(
                    style: TextButton.styleFrom(backgroundColor: Colors.red),
                    onPressed: () {
                      operation('add');
                    },
                    child: const Text(
                      "+",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                  TextButton(
                    style: TextButton.styleFrom(backgroundColor: Colors.red),
                    onPressed: () {
                      operation('sub');
                    },
                    child: const Text(
                      "-",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                  TextButton(
                    style: TextButton.styleFrom(backgroundColor: Colors.red),
                    onPressed: () {
                      operation('mul');
                    },
                    child: const Text(
                      "x",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                  TextButton(
                    style: TextButton.styleFrom(backgroundColor: Colors.red),
                    onPressed: () {
                      operation('div');
                    },
                    child: const Text(
                      "/",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
