from django.db import models

class User(models.Model):
    ROLE_CHOICES = [
        ('Customer', 'Customer'),
        ('HotelOwner', 'HotelOwner'),
    ]
    username = models.CharField(max_length=50)
    email = models.EmailField(unique=True)
    password = models.CharField(max_length=255)
    role = models.CharField(max_length=20, choices=ROLE_CHOICES)
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.username


class Hotel(models.Model):
    name = models.CharField(max_length=100)
    address = models.TextField()
    phone = models.CharField(max_length=15)
    owner = models.ForeignKey(User, on_delete=models.CASCADE, related_name='hotels')
    rating = models.FloatField(null=True, blank=True)  
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.name


class Room(models.Model):
    room_number = models.CharField(max_length=10)
    price_per_night = models.DecimalField(max_digits=10, decimal_places=2)
    capacity = models.IntegerField()
    availability = models.BooleanField(default=True)
    hotel = models.ForeignKey(Hotel, on_delete=models.CASCADE, related_name='rooms')
    description = models.TextField(null=True, blank=True)

    def __str__(self):
        return f"Room {self.room_number} - {self.hotel.name}"


class Reservation(models.Model):
    STATUS_CHOICES = [
        ('Pending', 'Pending'),
        ('Confirmed', 'Confirmed'),
        ('Cancelled', 'Cancelled'),
    ]
    user = models.ForeignKey(User, on_delete=models.CASCADE, related_name='reservations')
    room = models.ForeignKey(Room, on_delete=models.CASCADE, related_name='reservations')
    check_in_date = models.DateField()
    check_out_date = models.DateField()
    total_price = models.DecimalField(max_digits=10, decimal_places=2)
    status = models.CharField(max_length=20, choices=STATUS_CHOICES, default='Pending')
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"Reservation by {self.user.username} for {self.room}"


class Payment(models.Model):
    STATUS_CHOICES = [
        ('Pending', 'Pending'),
        ('Completed', 'Completed'),
        ('Failed', 'Failed'),
    ]
    reservation = models.OneToOneField(Reservation, on_delete=models.CASCADE, related_name='payment')
    amount = models.DecimalField(max_digits=10, decimal_places=2)
    payment_date = models.DateTimeField(auto_now_add=True)
    payment_method = models.CharField(max_length=50)
    status = models.CharField(max_length=20, choices=STATUS_CHOICES)

    def __str__(self):
        return f"Payment for {self.reservation}"


class Advertisement(models.Model):
    owner = models.ForeignKey(User, on_delete=models.CASCADE, related_name='advertisements')
    title = models.CharField(max_length=100)
    description = models.TextField()
    start_date = models.DateField()
    end_date = models.DateField()
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.title


class Review(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE, related_name='reviews')
    hotel = models.ForeignKey(Hotel, on_delete=models.CASCADE, related_name='reviews')
    rating = models.IntegerField()  
    comment = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"Review by {self.user.username} for {self.hotel.name}"


class Amenity(models.Model):
    hotel = models.ForeignKey(Hotel, on_delete=models.CASCADE, related_name='amenities')
    name = models.CharField(max_length=100)

    def __str__(self):
        return f"Amenity: {self.name} at {self.hotel.name}"


class RoomAmenity(models.Model):
    room = models.ForeignKey(Room, on_delete=models.CASCADE, related_name='room_amenities')
    amenity = models.ForeignKey(Amenity, on_delete=models.CASCADE, related_name='room_amenities')

    def __str__(self):
        return f"{self.amenity.name} in Room {self.room.room_number}"


class Promotion(models.Model):
    hotel = models.ForeignKey(Hotel, on_delete=models.CASCADE, related_name='promotions')
    title = models.CharField(max_length=100)
    description = models.TextField()
    discount_percentage = models.FloatField()
    start_date = models.DateField()
    end_date = models.DateField()

    def __str__(self):
        return self.title


class Notification(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE, related_name='notifications')
    message = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    is_read = models.BooleanField(default=False)

    def __str__(self):
        return f"Notification for {self.user.username}"


class Feedback(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE, related_name='feedbacks')
    message = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"Feedback by {self.user.username}"
