import 'package:flutter/material.dart';

class BookInfo extends StatefulWidget {
  final String? selectedId;
  final String? selectedTitle;
  final String? selectedDesc;
  final String? selectedAuthor;
  final String? selectedCategory;
  final String? selectedCompleted;

  // ignore: use_key_in_widget_constructors
  const BookInfo(
      {required this.selectedId,
      required this.selectedTitle,
      required this.selectedDesc,
      required this.selectedAuthor,
      required this.selectedCategory,
      required this.selectedCompleted});

  @override
  State<BookInfo> createState() => _BookInfoState();
}

class _BookInfoState extends State<BookInfo> {
  final formKey = GlobalKey<FormState>();
  String selectedRadio = "";
  TextEditingController id = TextEditingController();
  TextEditingController title = TextEditingController();
  TextEditingController desc = TextEditingController();
  TextEditingController author = TextEditingController();
  TextEditingController category = TextEditingController();
  String completed = "";

  @override
  void initState() {
    id.text = widget.selectedId!;
    title.text = widget.selectedTitle!;
    desc.text = widget.selectedDesc!;
    author.text = widget.selectedAuthor!;
    category.text = widget.selectedCategory!;
    completed = widget.selectedCompleted!;

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          backgroundColor: Colors.transparent,
          title: const Text(
            "Book Information",
            style: TextStyle(
              fontSize: 25,
              color: Colors.black,
            ),
          ),
          elevation: 0,
          leading: const BackButton(
            color: Colors.black,
          )),
      body: SingleChildScrollView(
        child: Container(
          padding: const EdgeInsets.only(
            right: 40,
            left: 40,
          ),
          child: Form(
            key: formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const SizedBox(height: 5),
                TextFormField(
                  enabled: false,
                  controller: id,
                  decoration: const InputDecoration(
                    labelText: "ID",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  enabled: false,
                  controller: title,
                  decoration: const InputDecoration(
                    labelText: "Title",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  enabled: false,
                  controller: desc,
                  decoration: const InputDecoration(
                    labelText: "Description",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  enabled: false,
                  controller: author,
                  decoration: const InputDecoration(
                    labelText: "Author",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  enabled: false,
                  controller: category,
                  decoration: const InputDecoration(
                    labelText: "Category",
                  ),
                ),
                const SizedBox(height: 30),
                Row(
                  children: [
                    const Text('Completed:'),
                    Padding(
                      padding: const EdgeInsets.only(left: 20),
                      child: Text(completed),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
