# Ôn tập Spring Boot

## Các câu có khả năng xuất hiện trong đề thi

## Câu 1. Trình bày vòng đời của một request trong Spring Boot

1. **Controller** nhận HTTP request từ client, nhận dữ liệu đầu vào và gọi Service.
2. **Service** xử lý nghiệp vụ, gọi Repository nếu cần truy cập dữ liệu.
3. **Repository** thao tác với cơ sở dữ liệu rồi trả kết quả về Service.
4. **Service** trả kết quả về Controller.
5. **Controller** trả response cho client, gồm mã trạng thái HTTP và dữ liệu. Với REST API, dữ liệu thường được Spring chuyển thành JSON.

## Câu 2. Phân biệt @Component, @Service, @Repository, @Controller, @Entity

`@Component`, `@Service`, `@Repository`, `@Controller` đánh dấu thành phần để Spring phát hiện qua component scanning và quản lý dưới dạng bean. `@Entity` đánh dấu lớp thực thể trong JPA.

| Annotation | Vai trò |
|---|---|
| `@Component` | Đánh dấu một thành phần dùng chung, không xác định tầng cụ thể. |
| `@Service` | Đánh dấu lớp thuộc tầng xử lý nghiệp vụ. |
| `@Repository` | Đánh dấu thành phần truy cập dữ liệu, hỗ trợ cơ chế chuyển đổi ngoại lệ truy cập dữ liệu sang hệ ngoại lệ của Spring. |
| `@Controller` | Đánh dấu lớp tiếp nhận và xử lý request trong Spring MVC, thường dùng để trả về view. |
| `@Entity` | Đánh dấu lớp Java là thực thể JPA, ánh xạ với bảng trong cơ sở dữ liệu. Mỗi đối tượng tương ứng với một bản ghi. |

`@Service`, `@Repository`, `@Controller` đều là các dạng chuyên biệt của `@Component`.

`@Entity` thuộc JPA, không phải dạng chuyên biệt của `@Component` và không tự đăng ký lớp thành Spring bean.

## Câu 3. Dependency Injection trong Spring hoạt động như thế nào?

**Dependency Injection (DI)** là cơ chế Spring cung cấp các đối tượng phụ thuộc cho một đối tượng, thay vì để đối tượng đó tự tạo chúng bằng `new`.

Spring IoC Container tạo và quản lý các bean, xác định dependency rồi inject bean phù hợp qua constructor, setter hoặc field. Spring thường chọn bean theo kiểu dữ liệu; nếu có nhiều bean phù hợp, có thể dùng `@Qualifier` để chỉ định hoặc `@Primary` để ưu tiên.

**Lợi ích:** Giảm phụ thuộc chặt giữa các thành phần, dễ thay thế và kiểm thử.

## Câu 5. Cấu trúc cơ bản của một ứng dụng Spring Boot

Ứng dụng Spring Boot theo mô hình phân tầng thường gồm:

| Thành phần | Chức năng |
|---|---|
| Lớp khởi động | Chứa `@SpringBootApplication` và hàm `main()` gọi `SpringApplication.run()`. |
| Controller | Nhận request và trả response. |
| Service | Xử lý nghiệp vụ. |
| Repository | Truy cập cơ sở dữ liệu. |
| Model/Entity | Biểu diễn dữ liệu; entity ánh xạ với bảng khi dùng JPA. |
| Resources | Chứa `application.properties` để cấu hình cổng server, kết nối cơ sở dữ liệu và JPA/Hibernate. |
| File build | `pom.xml` khai báo dependency và cấu hình build dự án bằng Maven. |

## Câu 6. @RestController khác @Controller như thế nào?

| `@Controller` | `@RestController` |
|---|---|
| Thường dùng cho ứng dụng MVC trả về giao diện. | Thường dùng để xây dựng REST API trả về dữ liệu. |
| Giá trị trả về kiểu `String` thường được hiểu là tên view. | Giá trị trả về được ghi vào body của response, thường ở dạng JSON. |
| Muốn trả dữ liệu trực tiếp có thể thêm `@ResponseBody` vào phương thức. | Đã bao gồm tác dụng của `@ResponseBody`. |

**Cần nhớ:** `@RestController` tương đương `@Controller` kết hợp `@ResponseBody`.

## Câu dự đoán 1. MVC là gì? Trình bày vai trò của từng thành phần trong mô hình MVC

MVC (Model–View–Controller) là mô hình tổ chức ứng dụng thành ba thành phần:

- **Model:** Quản lý dữ liệu và xử lý nghiệp vụ.
- **View:** Hiển thị dữ liệu và giao diện cho người dùng.
- **Controller:** Tiếp nhận yêu cầu, điều phối Model xử lý và lựa chọn View để hiển thị kết quả.

## Câu dự đoán 2. Kể tên 10 công cụ, nền tảng hoặc bộ phần mềm hỗ trợ phát triển website hướng dữ liệu và nêu công dụng chính

| STT | Công cụ / nền tảng | Công dụng chính |
|---|---|---|
| 1 | Eclipse | IDE hỗ trợ lập trình Java. |
| 2 | Visual Studio Code | Soạn thảo và phát triển mã nguồn. |
| 3 | Spring Tools | Hỗ trợ phát triển ứng dụng Spring/Spring Boot. |
| 4 | Postman | Gửi request và kiểm tra API. |
| 5 | MySQL Workbench | Cung cấp giao diện viết SQL, thiết kế và quản trị cơ sở dữ liệu MySQL. |
| 6 | MySQL Server | Hệ quản trị cơ sở dữ liệu, lưu trữ dữ liệu và thực thi truy vấn SQL. |
| 7 | Git | Quản lý phiên bản mã nguồn. |
| 8 | GitHub | Lưu trữ repository và hỗ trợ cộng tác phát triển. |
| 9 | Google Chrome | Truy cập, kiểm tra website và gỡ lỗi bằng Chrome DevTools. |
| 10 | Spring Initializr | Công cụ web dùng để tạo và cấu hình khung dự án Spring Boot. |

## Câu dự đoán 3. Spring Boot là gì? Cơ chế tự động cấu hình hoạt động như thế nào?

**Spring Boot** là framework phát triển từ Spring, giúp xây dựng ứng dụng nhanh hơn nhờ starter dependency, tự động cấu hình và máy chủ nhúng.

Cơ chế tự động cấu hình dựa vào các thư viện có trong project và cấu hình trong `application.properties` để tự tạo các bean phù hợp. Lập trình viên vẫn có thể tự cấu hình để thay đổi cấu hình mặc định.

## Câu dự đoán 4. Bean và IoC Container trong Spring là gì? Chúng có chức năng gì?

- **Bean:** Là đối tượng được Spring tạo và quản lý.
- **IoC Container:** Là bộ phận tạo bean, quản lý vòng đời và cung cấp các dependency cần thiết cho bean.

IoC Container là nền tảng giúp Spring thực hiện Dependency Injection.

## Câu dự đoán 5. Phân biệt JPA, Hibernate và Spring Data JPA

- **JPA:** Là đặc tả quy định cách ánh xạ đối tượng Java với cơ sở dữ liệu.
- **Hibernate:** Là công cụ triển khai JPA, thực hiện ánh xạ và thao tác dữ liệu.
- **Spring Data JPA:** Đơn giản hóa việc truy cập dữ liệu thông qua Repository như `JpaRepository` và sử dụng một JPA provider, thường là Hibernate.

## Câu hỏi ôn tập bổ sung

Các câu dưới đây dùng để củng cố kiến thức CRUD cơ bản, chưa có thông tin xác nhận sẽ xuất hiện trong đề thi.

**Câu bổ sung 1. Các annotation `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` có tác dụng gì?**

Ánh xạ request HTTP đến phương thức xử lý trong Controller:

- `@GetMapping`: Xử lý GET, thường dùng để lấy dữ liệu.
- `@PostMapping`: Xử lý POST, thường dùng để tạo mới.
- `@PutMapping`: Xử lý PUT, thường dùng để cập nhật.
- `@DeleteMapping`: Xử lý DELETE, thường dùng để xóa.

**Câu bổ sung 2. Phân biệt `@PathVariable` và `@RequestBody`.**

- `@PathVariable`: Lấy giá trị từ biến trong đường dẫn URL.
- `@RequestBody`: Chuyển dữ liệu trong body của request thành đối tượng Java.

**Câu bổ sung 3. `@RequestMapping` có tác dụng gì?**

Khai báo ánh xạ request đến Controller hoặc phương thức xử lý. Khi đặt trên lớp Controller, nó thường xác định đường dẫn chung cho các API trong lớp.

**Câu bổ sung 4. `JpaRepository` là gì? Hai tham số kiểu có ý nghĩa gì?**

`JpaRepository` là interface của Spring Data JPA, cung cấp các phương thức truy cập dữ liệu có sẵn như `findAll()`, `findById()`, `save()`, `delete()`.

Hai tham số kiểu lần lượt là **kiểu entity** và **kiểu khóa chính**.

**Câu bổ sung 5. `@Id` và `@GeneratedValue` có tác dụng gì?**

- `@Id`: Xác định thuộc tính khóa chính của entity.
- `@GeneratedValue`: Khai báo cách tự động sinh giá trị khóa chính.

**Câu bổ sung 6. `ResponseEntity` dùng để làm gì?**

Đại diện cho HTTP response, giúp tùy chỉnh **mã trạng thái HTTP, header và body** trả về client.

**Câu bổ sung 7. Vì sao nên chia ứng dụng thành Controller, Service và Repository?**

Để phân chia trách nhiệm: Controller xử lý giao tiếp HTTP, Service xử lý nghiệp vụ, Repository truy cập dữ liệu. Cách chia này giúp mã nguồn dễ bảo trì và kiểm thử.

**Câu bổ sung 8. `@SpringBootApplication` có tác dụng gì?**

Đánh dấu lớp cấu hình chính của ứng dụng Spring Boot, kết hợp ba chức năng: khai báo cấu hình, bật tự động cấu hình và quét component.


