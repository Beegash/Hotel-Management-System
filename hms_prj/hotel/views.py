from django.shortcuts import render
from .models import Hotel
from django.shortcuts import redirect
from .models import Hotel
from django.contrib.auth.decorators import login_required

def login_view(request):
    return render(request, 'hotel/login.html')
def register_view(request):
    return render(request, 'hotel/register.html')
def welcome_view(request):
    return render(request, 'hotel/welcome.html')

def hotels_list(request):
    hotels = Hotel.objects.all()  
    return render(request, 'hotel/hotels_list.html', {'hotels': hotels})

@login_required
def add_hotel(request):
    if request.method == 'POST':
        name = request.POST['name']
        address = request.POST['address']
        phone = request.POST['phone']
        owner = request.user  
        Hotel.objects.create(name=name, address=address, phone=phone, owner=owner)
        return redirect('hotels_list')
    return render(request, 'hotel/add_hotel.html')

