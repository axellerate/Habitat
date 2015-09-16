'''
	Habit@ API

	Author: Kris Vukasinovic
	Email: krisvdev@gmail.com

'''

# Cloud Endpoints Libraries
import endpoints
from protorpc import messages
from protorpc import message_types
from protorpc import remote

#import Datastore models
from models import *

'''
	Users API
'''
api_version = "1.00"


class Response(messages.Message):
    message = messages.StringField(1)
    success = messages.BooleanField(2)

class CreateUser(messages.Message):
    user_id = messages.StringField(1)
    car_id = messages.StringField(2)
    alternate_transport = messages.StringField(3)
    electricity = messages.FloatField(4)
    water = messages.FloatField(5)
    gas = messages.FloatField(6)
    city = messages.StringField(7)


@endpoints.api(name = 'users', version = api_version,
               description = 'User Management Resources')
class UsersApi(remote.Service):

    @endpoints.method(CreateUser, Response,
                        name = 'create',
                        path = 'create',
                        http_method = 'POST')
    def create(self, request):
        user = Users.save(request.user_id, request.car_id, 
            request.alternate_transport, request.city,
            request.electricity, request.gas, request.water)

        return Response(message = "User created successfully", success = True)



application = endpoints.api_server([UsersApi,])
