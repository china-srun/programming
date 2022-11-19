import 'package:book_tracker/theme_changer.dart';
import 'package:flutter/material.dart';
import 'screens/home_page.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ThemeBuilder(
      builder: (context, brightness) {
        return MaterialApp(
          title: "Book Tracker",
          debugShowCheckedModeBanner: false,
          theme: ThemeData(
            brightness: brightness,
          ),
          home: const HomePage(),
        );
      },
    );
  }
}
