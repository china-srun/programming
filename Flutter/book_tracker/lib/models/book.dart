// class Book {
//   String? id;
//   String? title;
//   String? description;
//   String? author;
//   String? category;
//   int? completed;

//   Book(
//       {this.id,
//       this.title,
//       this.description,
//       this.author,
//       this.category,
//       this.completed});

//   Book.fromJson(Map<String, dynamic> json) {
//     id = json['id'];
//     title = json['title'];
//     description = json['description'];
//     author = json['author'];
//     category = json['category'];
//     completed = json['completed'];
//   }

//   Map<String, dynamic> toJson() {
//     final Map<String, dynamic> data = new Map<String, dynamic>();
//     data['id'] = id;
//     data['title'] = title;
//     data['description'] = description;
//     data['author'] = author;
//     data['category'] = category;
//     data['completed'] = completed.toString();
//     return data;
//   }
// }

class Book {
    Book({
        this.id,
        required this.title,
        required this.description,
        required this.author,
        required this.category,
        required this.completed,
    });

    final String? id;
    final String? title;
    final String? description;
    final String? author;
    final String? category;
    final String? completed;

    factory Book.fromJson(Map<String, dynamic> json){ 
        return Book(
        id: json["id"],
        title: json["title"],
        description: json["description"],
        author: json["author"],
        category: json["category"],
        completed: json["completed"],
    );
    }

    Map<String, dynamic> toJson() => {
        "id": id,
        "title": title,
        "description": description,
        "author": author,
        "category": category,
        "completed": completed,
    };
}