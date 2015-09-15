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


@endpoints.api(name = 'users', version = api_version,
               description = 'User Management Resources')
class UsersApi(remote.Service):

    @endpoints.method(message_types.VoidMessage, Response,
                        name = 'create',
                        path = 'create',
                        http_method = 'POST')
    def create(self, request):
        return Response(message = "User created successfully", success = True)



application = endpoints.api_server([UsersApi,])
