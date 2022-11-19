import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String buttonName = "Click me please";
  int currentIndex = 0;
  @override
  Widget build(BuildContext context) {
    // starts with lowercase, it is called property
    // starts with uppercase, it is called widget
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Genshin Impact App"),
          backgroundColor: Colors.pink,
          centerTitle: true,
        ),
        body: Center(
          // ignore: sized_box_for_whitespace
          child: currentIndex == 0
              ? Container(
                  // mean ney tha ah size box ng vea yo width tang os mg, ber jg oy vea yo the entire screen yerng set height oy vea double.infinity tt tv pi chveng tv sdam and pi ler jos krom vea yo tang os
                  width: double.infinity,
                  height: double.infinity,
                  color: Colors.lightBlue,
                  child: Column(
                    // pi ler jos krom
                    mainAxisAlignment: MainAxisAlignment.center,
                    // pi chveng tv sdam
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      ElevatedButton(
                        onPressed: () {
                          setState(() {
                            buttonName = "you clicked me fk u man";
                          });
                        },
                        child: Text(buttonName),
                        style: ElevatedButton.styleFrom(
                          // onPrimary is text color, and primary is background color
                          onPrimary: Colors.white,
                          primary: Colors.pink,
                        ),
                      ),
                      ElevatedButton(
                        onPressed: () {
                          setState(() {
                            buttonName = "you clicked me fk u man";
                          });
                        },
                        child: Text(buttonName),
                        style: ElevatedButton.styleFrom(
                          onPrimary: Colors.white,
                          primary: Colors.pink,
                        ),
                      ),
                    ],
                  ),
                )
              : currentIndex == 1
                  ? const SettingPage()
                  : SingleChildScrollView(
                      child: Column(
                        children: [
                          Image.asset('images/genshin-impact.jpg'),
                          const Text("Genshin Impact version 2.0"),
                          const SizedBox(
                            height: 20,
                          ),
                          Image.asset('images/maxresdefault (1).jpg'),
                          const Text("Genshin Impact version 2.0"),
                          const SizedBox(
                            height: 20,
                          ),
                          Image.asset('images/genshin-impact-3.0.jpg'),
                          const Text("Genshin Impact version 2.0"),
                          const SizedBox(
                            height: 20,
                          ),
                          Image.asset(
                              'images/genshin-impact-all-characters.jpg'),
                          const Text("Genshin Impact version 2.0"),
                          ElevatedButton(
                            onPressed: () {
                              setState(() {
                                currentIndex = 0;
                              });
                            },
                            child: const Text("Back to Home"),
                          ),
                        ],
                      ),
                    ),
        ),
        bottomNavigationBar: BottomNavigationBar(
          items: const [
            BottomNavigationBarItem(
              icon: Icon(
                Icons.home,
                color: Colors.red,
              ),
              label: ("Home"),
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.settings,
                color: Colors.red,
              ),
              label: ("Setting"),
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.safety_check,
                color: Colors.red,
              ),
              label: ("Profile"),
            ),
          ],
          currentIndex: currentIndex,
          onTap: (int index) {
            setState(() {
              currentIndex = index;
            });
          },
        ),
      ),
    );
  }
}

class SettingPage extends StatelessWidget {
  const SettingPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                Navigator.of(context).push(
                  MaterialPageRoute(builder: (BuildContext context) {
                    return const SecondPage();
                  }),
                );
              },
              child: const Text("Go to second page!"),
              style: ElevatedButton.styleFrom(
                onPrimary: Colors.white,
                primary: Colors.grey,
              ),
            )
          ],
        ),
      ),
    );
  }
}

class SecondPage extends StatelessWidget {
  const SecondPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Welcome to Second Page"),
      ),
    );
  }
}
