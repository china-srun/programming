void main() {
  // dynamic datatype allows us to change its type
  dynamic x = 100;
  print(x.runtimeType);

  x = "KIT";
  print(x.runtimeType);

  String name = "China";
  print(name.codeUnits); // code points UTF-16 (16 bits) ascii only 8 bits

  String emoji = "😊";
  print(emoji.runes);

  String title = "China in epic";
  print(title.contains("China"));

  String subtitle = "Hello world my name is Mr. world wide";

  int pos = 0;
  int count = 0;
  while (true) {
    pos = subtitle.indexOf('world', pos);
    print(pos);
    if (pos >= 0) {
      ++count;
      pos = pos + 'world'.length;
    } else {
      break;
    }
  }
  print("World occurs $count times.");
}
